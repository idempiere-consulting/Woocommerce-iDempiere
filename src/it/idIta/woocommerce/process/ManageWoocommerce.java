package it.idIta.woocommerce.process;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.compiere.util.Env;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.icoderman.woocommerce.EndpointBaseType;
import com.icoderman.woocommerce.Woocommerce;

import it.idIta.woocommerce.model.MWooProducts;
import it.idIta.woocommerce.pojo.Category;
import it.idIta.woocommerce.pojo.Image;
import it.idIta.woocommerce.pojo.Order;
import it.idIta.woocommerce.pojo.Product;
import it.idIta.woocommerce.pojo.ProductAttribute;
import it.idIta.woocommerce.pojo.ProductAttributeTerm;

public class ManageWoocommerce {

	private Woocommerce wCommerce = null;
	private List<Category> listCategories = null;
	private ObjectMapper mapper = new ObjectMapper();

	public ManageWoocommerce(Woocommerce wooCommerce) {
		
		wCommerce = wooCommerce;
		//initSyncForProd();
	}
	
	public void initSyncForProd() {
		Map<String, String> params = new HashMap<>();
		
		List<?> wcProducts = wCommerce.getAll(EndpointBaseType.PRODUCTS.getValue(), params);
		MWooProducts.deleteAllWooProduct();
		DateTimeFormatter formatDateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
		wcProducts = mapper.convertValue(wcProducts, new TypeReference<List<Product>>(){});

		for(Object product : wcProducts) {
			saveProductWoo((Product)product, formatDateTime);
		}

		getProductCategory(null);
	}
	
	public Category getProductCategory(String name){
		Category category = null;
		//https://woocommerce.github.io/woocommerce-rest-api-docs/#list-all-product-categories LEGGI...
		 Map<String,String> queryParams= new TreeMap<String, String>();
		 queryParams.put("per_page", "100"); //'per_page'	type:integer	Maximum number of items to be returned in result set. Default is 10.
		 List<?> tmpList = null;
		if(name==null || name.trim().isEmpty()){
			tmpList = wCommerce.getAll(EndpointBaseType.PRODUCTS_CATEGORIES.getValue(), queryParams);
			mapper= new ObjectMapper();
			listCategories = mapper.convertValue(tmpList, new TypeReference<List<Category>>(){});
		}
		else{
			category = listCategories.stream()
					.filter(c ->c.getName().equals(name))
					.findAny()
					.orElse(null);
			//create New category into woocommerce
			if(category==null){
				List<Category>  listAdd = new ArrayList<Category>();
				Category prodCateg = new Category();
				prodCateg.setName(name);
				listAdd.add(prodCateg);
				updateCategoriesTOpost(listAdd,true);
					
				tmpList = wCommerce.getAll(EndpointBaseType.PRODUCTS_CATEGORIES.getValue(), queryParams);
				mapper= new ObjectMapper();
				listCategories = mapper.convertValue(tmpList, new TypeReference<List<Category>>(){});
				category = listCategories.stream()
						.filter(c ->c.getName().equals(name))
						.findAny()
						.orElse(null);
				if(category!=null)
					return category;
				//refresh
				getProductCategory(null);
			}
			///
		}
		return category;
	}
	
	public List<Order> getwoo_Orders(){
		List<Order> orders = new ArrayList<Order>();
		Map<String, String> params = new HashMap<>();
		List<?> wcProducts = wCommerce.getAll(EndpointBaseType.ORDERS.getValue(), params);
		mapper = new ObjectMapper();
		orders = mapper.convertValue(wcProducts, new TypeReference<List<Order>>(){});
		return orders;
	}
	
	public Product getProductBySKU(String p_sku) {
		Product prd = null;
		
		Map<String, String> params = new HashMap<>();
		params.put("sku", p_sku);
		List<?> wcProducts = wCommerce.getAll(EndpointBaseType.PRODUCTS.getValue(), params);
		
		if(wcProducts!=null && wcProducts.size()>0) { 
			List<Product>products = new ArrayList<Product>();
			mapper = new ObjectMapper();
			products = mapper.convertValue(wcProducts, new TypeReference<List<Product>>() {});
			prd = products.get(0);
		}
		return prd;
	}
	
	public void updateProductsTOpost(List<Product> listWoo, boolean createNew){
		mapper = new ObjectMapper();
		List<Map<String, Object>> listCreate = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = null;
		for (Product prd : listWoo) {
			map = mapper.convertValue(prd, new TypeReference<Map<String, Object>>() {});
			listCreate.add(map);
		}
		String keyBatch = (createNew)?"create":"update";
		TreeMap<String, Object> batchMap = new TreeMap<String, Object>();
		batchMap.put(keyBatch, listCreate);
		wCommerce.batch(EndpointBaseType.PRODUCTS.getValue(), batchMap);
	}
	
	public void updateCategoriesTOpost(List<Category> listCategories, boolean createNew){
		mapper = new ObjectMapper();
		List<Map<String, Object>> listCreate = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = null;
		for (Category cat : listCategories) {
			map = mapper.convertValue(cat, new TypeReference<Map<String, Object>>() {});
			listCreate.add(map);
		}
		String keyBatch = (createNew)?"create":"update";
		TreeMap<String, Object> batchMap = new TreeMap<String, Object>();
		batchMap.put(keyBatch, listCreate);
		wCommerce.batch(EndpointBaseType.PRODUCTS_CATEGORIES.getValue(), batchMap);
	}
	
	public void updateOrdersTOpost(List<Order> listOrders, boolean createNew) {
		mapper = new ObjectMapper();
		List<Map<String, Object>> listCreate = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = null;
		for (Order ord : listOrders) {
			map = mapper.convertValue(ord, new TypeReference<Map<String, Object>>() {});
			listCreate.add(map);
		}
		String keyBatch = (createNew)?"create":"update";
		TreeMap<String, Object> batchMap = new TreeMap<String, Object>();
		batchMap.put(keyBatch, listCreate);
		wCommerce.batch(EndpointBaseType.ORDERS.getValue(), batchMap);
	}
	
	public List<ProductAttribute> updateProdAttributeTOpost(List<ProductAttribute> listProductAttr ,boolean createNew) {
		mapper = new ObjectMapper();
		List<Map<String, Object>> listCreate = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = null;
		for(ProductAttribute prdAtt: listProductAttr) {
			map = mapper.convertValue(prdAtt, new TypeReference<Map<String, Object>>() {});
			listCreate.add(map);
		}
		String keyBatch = (createNew)?"create":"update";
		TreeMap<String, Object> batchMap = new TreeMap<String, Object>();
		batchMap.put(keyBatch, listCreate);
		Map<?,?> response = wCommerce.batch(EndpointBaseType.PRODUCTS_ATTRIBUTES.getValue(), batchMap);
		List<ProductAttribute> listResponse = new ArrayList<ProductAttribute>();
		for(Map.Entry<?, ?> entry: response.entrySet()) {
			List<Map<String, Object>> value = (List<Map<String, Object>>) entry.getValue();
			for (Map<String, Object> map2 : value) {
				if(map2.get("id")!=null && ((Integer)map2.get("id")).intValue()==0)
					continue;
				else {
					mapper = new ObjectMapper();
					ProductAttribute prd = mapper.convertValue(map2, new TypeReference<ProductAttribute>(){});
					listResponse.add(prd);
				}
			}
			//ArrayList<E>
		}
		return listResponse;
	
	}
	
	public List<ProductAttributeTerm> updateProdAttributeTermTOpost(List<ProductAttributeTerm> listProductAttrTerm ,boolean createNew, int idProductAttribute) {
		mapper = new ObjectMapper();
		List<Map<String, Object>> listCreate = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = null;
		for(ProductAttributeTerm prdAttTerm: listProductAttrTerm) {
			map = mapper.convertValue(prdAttTerm, new TypeReference<Map<String, Object>>() {});
			listCreate.add(map);
		}
		String keyBatch = (createNew)?"create":"update";
		TreeMap<String, Object> batchMap = new TreeMap<String, Object>();
		batchMap.put(keyBatch, listCreate);
		Map<?,?> response = wCommerce.batchExtra(EndpointBaseType.PRODUCTS_ATTRIBUTES_TERMS.getValue(), batchMap, true, idProductAttribute);
		List<ProductAttributeTerm> listResponse = new ArrayList<ProductAttributeTerm>();
		for(Map.Entry<?, ?> entry: response.entrySet()) {
			List<Map<String, Object>> value = (List<Map<String, Object>>) entry.getValue();
			for (Map<String, Object> map2 : value) {
				if(map2.get("id")!=null && ((Integer)map2.get("id")).intValue()==0)
					continue;
				else {
					mapper = new ObjectMapper();
					ProductAttributeTerm prd = mapper.convertValue(map2, new TypeReference<ProductAttributeTerm>(){});
					listResponse.add(prd);
				}
			}
			//ArrayList<E>
		}
		return listResponse;
	
	}
	
	private boolean saveProductWoo(Product responseProd, DateTimeFormatter formatDateTime){
		LocalDateTime lDT = null;
		MWooProducts m_wooProd = null;
		
		m_wooProd = new MWooProducts(Env.getCtx(), 0, null);		
		m_wooProd.setName(responseProd.getName());
		m_wooProd.setLIT_IdProdWoo(responseProd.getId());
		m_wooProd.setLIT_NameProdWoo(responseProd.getName());
		lDT = LocalDateTime.from(formatDateTime.parse(responseProd.getDateCreated()));
		m_wooProd.setLIT_CreatedAt(Timestamp.valueOf(lDT));
		lDT = LocalDateTime.from(formatDateTime.parse(responseProd.getDateModified()));
		m_wooProd.setLIT_UpdatedAt(Timestamp.valueOf(lDT));
		m_wooProd.setLIT_TypeProdWoo(responseProd.getType());
		m_wooProd.setLIT_StatusWoo(responseProd.getStatus());
		m_wooProd.setLIT_IsDownloadable(responseProd.isDownloadable());
		m_wooProd.setLIT_IsVirtual(responseProd.isVirtual());
		m_wooProd.setLIT_Permalink(responseProd.getPermalink());
		m_wooProd.setLIT_Sku(responseProd.getSku());
		m_wooProd.setPrice((responseProd.getPrice()==null || responseProd.getPrice().isEmpty())?BigDecimal.ZERO:new BigDecimal(responseProd.getPrice()));
		m_wooProd.setLIT_RegularPrice((responseProd.getRegularPrice()==null || responseProd.getRegularPrice().isEmpty())?BigDecimal.ZERO:new BigDecimal(responseProd.getRegularPrice()));
		m_wooProd.setLIT_SalePrice((responseProd.getSalePrice()==null || responseProd.getSalePrice().isEmpty())?BigDecimal.ZERO:new BigDecimal(responseProd.getSalePrice()));
		if(responseProd.getDateOnSaleFrom()!=null) {
			lDT = LocalDateTime.from(formatDateTime.parse((String)responseProd.getDateOnSaleFrom()));
			m_wooProd.setLIT_SalePriceDatesFrom(Timestamp.valueOf(lDT));
		}
		if(responseProd.getDateOnSaleTo()!=null) {
			lDT = LocalDateTime.from(formatDateTime.parse((String)responseProd.getDateOnSaleFrom()));
			m_wooProd.setLIT_SalePriceDatesTo(Timestamp.valueOf(lDT));
		}
		m_wooProd.setLIT_PriceHtml(responseProd.getPriceHtml());
		m_wooProd.setLIT_IsTaxable((responseProd.getTaxStatus()!= null && responseProd.getTaxStatus().equalsIgnoreCase("taxable"))?true:false); // TODO è giusto???
		m_wooProd.setLIT_TaxStatus(responseProd.getTaxStatus());
		m_wooProd.setLIT_TaxClass(responseProd.getTaxClass());
		m_wooProd.setLIT_IsManagingStock(responseProd.isManageStock());
		if(m_wooProd.isLIT_IsManagingStock() && responseProd.getStockQuantity()==null)
			m_wooProd.setLIT_StockQuantity(0);
		else if(m_wooProd.isLIT_IsManagingStock() && responseProd.getStockQuantity()!=null)
			m_wooProd.setLIT_StockQuantity((Integer)responseProd.getStockQuantity());
		m_wooProd.setLIT_IsInStock((responseProd.getStockStatus()!=null && responseProd.getStockStatus().equalsIgnoreCase("instock"))?true:false);
		m_wooProd.setLIT_IsBackordersAllowed(responseProd.isBackordersAllowed());
		m_wooProd.setLIT_IsBackordered(responseProd.isBackordered());
		m_wooProd.setLIT_IsSoldIndividually(responseProd.isSoldIndividually());
		m_wooProd.setLIT_IsPurchaseable(responseProd.isPurchasable());
		m_wooProd.setLIT_IsFeatured(responseProd.isFeatured());
		//m_wooProd.setLIT_IsVisible(responseProd.isVisible());
		m_wooProd.setLIT_CatalogVisibility(responseProd.getCatalogVisibility());
		m_wooProd.setLIT_IsOnSale(responseProd.isOnSale());
		m_wooProd.setWeight((responseProd.getWeight()==null || responseProd.getWeight().isEmpty())?BigDecimal.ZERO:new BigDecimal(responseProd.getWeight()));
		if(responseProd.getDimensions()!=null) {
			m_wooProd.setLIT_DimHeight((responseProd.getDimensions().getHeight()==null || responseProd.getDimensions().getHeight().isEmpty())?BigDecimal.ZERO:new BigDecimal(responseProd.getDimensions().getHeight()));
			m_wooProd.setLIT_DimLength((responseProd.getDimensions().getLength()==null || responseProd.getDimensions().getLength().isEmpty())?BigDecimal.ZERO:new BigDecimal(responseProd.getDimensions().getLength()));
			m_wooProd.setLIT_DimWidth((responseProd.getDimensions().getWidth()==null || responseProd.getDimensions().getWidth().isEmpty())?BigDecimal.ZERO:new BigDecimal(responseProd.getDimensions().getWidth()));
		}
		//m_wooProd.setLIT_DimUnit(new BigDecimal(responseProd.getDimensions().getUnit()));
		m_wooProd.setLIT_IsShippingRequired(responseProd.isShippingRequired());
		m_wooProd.setLIT_IsShippingTaxable(responseProd.isShippingTaxable());
		//m_wooProd.setLIT_IsShippingClass((responseProd.isShippingClass()==null)?false:responseProd.isShippingClass());
		if(responseProd.getShippingClassId()>0)
			m_wooProd.setLIT_ShippingClassId(responseProd.getShippingClassId());
		m_wooProd.setLIT_DescriptionWoo(responseProd.getDescription());
		//m_wooProd.setLIT_IsEnableHtmlDescription(responseProd.isEnableHtmlDescription()==null)?false:responseProd.isEnableHtmlDescription());
		m_wooProd.setLIT_ShortDescription(responseProd.getShortDescription());
		m_wooProd.setLIT_EnabledHtmlShortDescr(responseProd.getDescription());
		m_wooProd.setLIT_IsReviewsAllowed(responseProd.isReviewsAllowed());
		m_wooProd.setLIT_AverageRating(responseProd.getAverageRating());
		m_wooProd.setLIT_RatingCount(responseProd.getRatingCount());
		m_wooProd.setLIT_ParentId_Woo(responseProd.getParentId());
		m_wooProd.setLIT_DownloadLimit(responseProd.getDownloadLimit());
		m_wooProd.setLIT_DownloadExpiry(responseProd.getDownloadExpiry());
		//if(responseProd.getDownloadType()!=null)
		//	m_wooProd.setLIT_DownloadType(responseProd.getDownloadType().name());
		m_wooProd.setLIT_PurchaseNote(responseProd.getPurchaseNote());
		m_wooProd.setLIT_TotalSales(responseProd.getTotalSales());
		m_wooProd.setLIT_ProductUrl(responseProd.getExternalUrl());
		m_wooProd.setLIT_ButtonText(responseProd.getButtonText());
		if(responseProd.getMenuOrder()>=0)
			m_wooProd.setLIT_MenuOrder(responseProd.getMenuOrder());
		if(responseProd.getImages()!=null && responseProd.getImages().size()>0){
			it.idIta.woocommerce.pojo.Image image = null;
			for (Image imgProd : responseProd.getImages()) {
				if(imgProd.getSrc()!=null && !imgProd.getSrc().isEmpty()){
					image = imgProd;
					break;
				}
			}
			
			if(image!= null)
				m_wooProd.setLIT_ImageUrl(image.getSrc());
		}
		if(responseProd.getCategories()!=null && !responseProd.getCategories().isEmpty()){
			for (Category catg : responseProd.getCategories()) {
				if(!catg.getName().equalsIgnoreCase("Senza categoria")){
					m_wooProd.setLIT_CategoryWoo(catg.getName());
					break;
				}
			} 
		}

		if(!m_wooProd.save())
			return false;
		
		return true;
	}

}
