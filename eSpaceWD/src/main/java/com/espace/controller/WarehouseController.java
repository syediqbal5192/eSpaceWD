package com.espace.controller;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.espace.service.WarehouseManager;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.amazonaws.auth.PropertiesCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.espace.entity.SalesPipeLineEntity;
import com.espace.entity.WarehouseEntity;
import com.espace.model.Dashboard;
import com.espace.model.Warehouse;
import com.espace.persistance.HibernateUtil;


@Controller
public class WarehouseController {

	
	@Autowired
	WarehouseManager warehouseManager;
	
	
	/*Adds New Warehouse to Datatbase*/
	
	@RequestMapping(value="/addWarehouse",method=RequestMethod.POST)
	public @ResponseBody String addWarehouse(HttpSession session,HttpServletRequest request,HttpServletResponse response){
		
	    String warehouseName=nvl(request.getParameter("warehouseName"));
	    Integer floorBuiltupArea=Integer.parseInt(nvl(request.getParameter("floorBuiltupArea")));
	    Integer floorCarpetArea=Integer.parseInt(nvl(request.getParameter("floorCarpetArea")));
	    Integer rackBuiltupArea=Integer.parseInt(nvl(request.getParameter("rackBuiltupArea")));
	    Integer palette_positions=Integer.parseInt(nvl(request.getParameter("palette_positions")));
		Integer totalNumberOfDocks=Integer.parseInt(nvl(request.getParameter("totalNumberOfDocks")));
				
		String warehouseStatus= warehouseManager.addWarehouse(warehouseName, floorBuiltupArea, floorCarpetArea, rackBuiltupArea, palette_positions,totalNumberOfDocks);
		
		return warehouseStatus;
		
	}
	
	
	@RequestMapping(value="/updateWarehouse",method=RequestMethod.POST)
	public @ResponseBody String doPersonalityUpdateM(HttpSession session,HttpServletRequest request,HttpServletResponse response){
		
		Integer warehouseId = Integer.parseInt(nvl(request.getParameter("warehouseId")));
		String warehouseName=nvl(request.getParameter("warehouseName"));
	    Integer floorBuiltupArea=Integer.parseInt(nvl(request.getParameter("floorBuiltupArea")));
	    Integer floorCarpetArea=Integer.parseInt(nvl(request.getParameter("floorCarpetArea")));
	    Integer rackBuiltupArea=Integer.parseInt(nvl(request.getParameter("rackBuiltupArea")));
	    Integer palette_positions=Integer.parseInt(nvl(request.getParameter("palette_positions")));
		Integer totalNumberOfDocks = Integer.parseInt(nvl(request.getParameter("totalNumberOfDocks")));
		Integer availableWarehouseFloor=Integer.parseInt(nvl(request.getParameter("availableWarehouseFloor")));
		Integer availableWarehouseRack = Integer.parseInt(nvl(request.getParameter("availableWarehouseRack")));
		
		
		String status=warehouseManager.updateWarehouse(warehouseId, warehouseName, floorBuiltupArea, floorCarpetArea, rackBuiltupArea, palette_positions, totalNumberOfDocks,availableWarehouseFloor,availableWarehouseRack);
		
		
		
		return status;
		
	}
	
	
	
	@RequestMapping(value="/deleteWarehouseById",method=RequestMethod.POST)
	public @ResponseBody String deleteWarehouseById(HttpSession session,HttpServletRequest request,HttpServletResponse response){
		
		Integer warehouseId = Integer.parseInt(nvl(request.getParameter("warehouseId")));
			
		String status=warehouseManager.deleteWarehouse(warehouseId);
		
		
		
		return status;
		
	}
	
	
	
	
	@RequestMapping(value="/listWarehouse",method=RequestMethod.GET)
	public @ResponseBody String getWarehousesList(HttpSession session,HttpServletRequest request,HttpServletResponse response){
		response.setContentType("application/json");
		
		List<Warehouse> warehouseArrayList=new ArrayList<Warehouse>();
		warehouseArrayList = warehouseManager.listWarehouse(); 
	    Gson gson = new GsonBuilder().setPrettyPrinting().create();
	    String json = gson.toJson(warehouseArrayList);
		return json;
	}
	
	

	@RequestMapping(value="/listWarehouseByActive",method=RequestMethod.GET)
	public @ResponseBody String getListWarehouseByActive(HttpSession session,HttpServletRequest request,HttpServletResponse response){
		response.setContentType("application/json");
		List<Warehouse> warehouseArrayList=new ArrayList<Warehouse>();
		 warehouseArrayList= warehouseManager.listWarehouseByActive(); 
	    Gson gson = new GsonBuilder().setPrettyPrinting().create();
	    String json = gson.toJson(warehouseArrayList);
		return json;
	}
	
	@RequestMapping(value="/listWarehouseDrillDown",method=RequestMethod.GET)
	public @ResponseBody String getListWarehouseDrillDown(HttpSession session,HttpServletRequest request,HttpServletResponse response){
		response.setContentType("application/json");
		
		String warehouseName = nvl(request.getParameter("warehouseName"));
		List<Warehouse> warehouseArrayList=new ArrayList<Warehouse>();
		warehouseArrayList = warehouseManager.listWarehouseDrillDown(warehouseName);
	    Gson gson = new GsonBuilder().setPrettyPrinting().create();
	    String json = gson.toJson(warehouseArrayList);
		return json;
	}
	
	@RequestMapping(value="/listWarehouseById",method=RequestMethod.GET)
	public @ResponseBody String getWarehousesListById(HttpSession session,HttpServletRequest request,HttpServletResponse response){
		response.setContentType("application/json");
		
		Integer warehouseId = Integer.parseInt(nvl(request.getParameter("warehouseId")));
		List<Warehouse> warehouseArrayList=new ArrayList<Warehouse>();
		warehouseArrayList = warehouseManager.listWarehouseById(warehouseId);
	    Gson gson = new GsonBuilder().setPrettyPrinting().create();
	    String json = gson.toJson(warehouseArrayList);
		return json;
	}
	
	
	@RequestMapping(value="/getWarehouseAreaById",method=RequestMethod.GET)
	public @ResponseBody String getWarehouseAreaById(HttpSession session,HttpServletRequest request,HttpServletResponse response){
		response.setContentType("application/json");
		
		Integer warehouseId = Integer.parseInt(nvl(request.getParameter("selectedWarehouseId"))); 
		
		List<Warehouse> warehouseArrayList=new ArrayList<Warehouse>();
		warehouseArrayList = warehouseManager.getWarehouseAreaById(warehouseId);
	    Gson gson = new GsonBuilder().setPrettyPrinting().create();
	    String json = gson.toJson(warehouseArrayList);
		return json;
	}
	
	
	
	@RequestMapping(value="/getWarehouseDetailsById",method=RequestMethod.POST)
	public @ResponseBody String getWarehouseDetailsById(HttpSession session,HttpServletRequest request,HttpServletResponse response){
		response.setContentType("application/json");
		
		String json;
	
        Integer warehouseId= Integer.parseInt(nvl(request.getParameter("warehouseId")));
		
		HashMap<String, String> file=warehouseManager.getWarehousrDetailsByWHId(warehouseId);
	    Gson gson = new GsonBuilder().setPrettyPrinting().create();
	    json = gson.toJson(file);
		return json;
		
	}
	
	
	@RequestMapping(value="/dashboardIconInfo",method=RequestMethod.POST)
	public @ResponseBody String getDashboardIconInfo(HttpSession session,HttpServletRequest request,HttpServletResponse response){
		response.setContentType("application/json");
		
		HashMap<String, String> dashboardIconInfoList = warehouseManager.getDashboardIconInfo();
	    Gson gson = new GsonBuilder().setPrettyPrinting().create();
	    String json = gson.toJson(dashboardIconInfoList);
		return json;
	}
	
	
	@RequestMapping(value="/uploadFileDoc",method=RequestMethod.POST)  
	public String upload(@RequestParam CommonsMultipartFile file,HttpSession session,HttpServletRequest request,HttpServletResponse response){  
	        
		
		Integer salesPipeLineIdUpload = Integer.parseInt(nvl(request.getParameter("salesPipeLineIdUpload")));
			
		Session session2 = HibernateUtil.getSesssion();
	    Transaction transaction = null;
	    
			String path=session.getServletContext().getRealPath("/");
			
	        String filename=file.getOriginalFilename();  
	          
	        System.out.println(path+""+filename);  
	        try{  
	        byte barr[]=file.getBytes();  
	          
	        BufferedOutputStream bout=new BufferedOutputStream(  
	                 new FileOutputStream(path+"/"+filename));  
	        bout.write(barr);
	        
	        String existingBucketName = "aws-website-citisolutionswd-ri3dn";
	        String keyName = filename;
	        
	        String filePath = path+""+filename;
	       // byte[] bytes = IOUtils.toByteArray(barr);
	        String amazonFileUploadLocationOriginal=existingBucketName;
	        System.out.println(filePath+":"+amazonFileUploadLocationOriginal+":"+keyName);

	        AmazonS3 s3Client = new AmazonS3Client(new PropertiesCredentials(WarehouseController.class.getResourceAsStream("AwsCredentials.properties")));

	        System.out.println(s3Client);
	        //FileInputStream stream = new FileInputStream(barr);
	        ByteArrayInputStream stream = new ByteArrayInputStream(barr);
	        System.out.println(stream);;
	        ObjectMetadata objectMetadata = new ObjectMetadata();
	        System.out.println(objectMetadata);
	        objectMetadata.setContentLength(barr.length);
	        
	        PutObjectRequest putObjectRequest = new PutObjectRequest(amazonFileUploadLocationOriginal, keyName, stream, objectMetadata);
	        System.out.println(putObjectRequest);
	        PutObjectResult result = s3Client.putObject(putObjectRequest);
	        System.out.println(result);
	        System.out.println("Etag:" + result.getETag() + "-->" + result);
	      
	        transaction = session2.beginTransaction();
	        SalesPipeLineEntity salesPipeLine = (SalesPipeLineEntity) session2.get(SalesPipeLineEntity.class, salesPipeLineIdUpload);  
	         
	        salesPipeLine.setExistingBucketName(existingBucketName);
	        salesPipeLine.setKeyName(keyName);
	        
	       
			 session2.update(salesPipeLine); 
	         transaction.commit();
	          
	        }catch(Exception e){
	        	 if (transaction!=null) transaction.rollback();
	        	System.out.println(e);}  
	        return "succesfull";  
	    } 
	
	
	

	

@RequestMapping(value="/getDownloadDocById",method=RequestMethod.POST)
public @ResponseBody String getDownloadDocById(HttpSession session,HttpServletRequest request,HttpServletResponse response) throws FileNotFoundException, IOException{
	response.setContentType("application/json");
	
	Integer salesPipeLineIdUpload = Integer.parseInt(nvl(request.getParameter("salesPipeLineIdUpload")));
	 String existingBucketName = null;
     String keyName = null;
	Session session2 = HibernateUtil.getSesssion();
	Transaction transaction = null;
	List<SalesPipeLineEntity> elementList = null;
      try{
         transaction = session2.beginTransaction();
	 Criteria criteria = session2.createCriteria(SalesPipeLineEntity.class, "salesPipeLine");
	 criteria.add(Restrictions.eq("salesPipeLine.salesPipeLineId", salesPipeLineIdUpload));
        
       elementList = new ArrayList<SalesPipeLineEntity>();
        elementList = (List<SalesPipeLineEntity>) criteria.list();
       
	        
	        for (int k = 0; k < elementList.size(); k++) {  
				
	        	existingBucketName = elementList.get(k).getExistingBucketName();
	        	keyName = elementList.get(k).getKeyName();
				 System.out.println(existingBucketName);
				 System.out.println(keyName);
				 
	        }		
        
        session2.getTransaction().commit();
    
        AmazonS3 s3Client = new AmazonS3Client(new PropertiesCredentials(WarehouseController.class.getResourceAsStream("AwsCredentials.properties")));
        	  
        	  GetObjectRequest requestValue = new GetObjectRequest(existingBucketName,keyName);
        	  System.out.println(requestValue);
        	  S3Object object = s3Client.getObject(requestValue);
        	  InputStream objectContent = object.getObjectContent();
        	  System.out.println(objectContent);
			
        	  
        	  String filename = "D://upload//"+keyName+".xls" ;
              HSSFWorkbook workbook = new HSSFWorkbook();
              HSSFSheet sheet = workbook.createSheet("FirstSheet"); 
        	  
              FileOutputStream fileOut = new FileOutputStream(filename);
              workbook.write(fileOut);
              workbook.close();
              fileOut.close();
              System.out.println("Your excel file has been generated!");
        	  
        	  IOUtils.copy(objectContent, new FileOutputStream(filename));
        
        
      }
		 catch (HibernateException e) {
			 if (transaction!=null) 
			    	transaction.rollback();
			    e.printStackTrace(); 
			 }
		 
	return "";
}

	
	
	public static String nvl(String str) {
        return (str == null) ? "" : str.trim();
    }
	
	
	
}
