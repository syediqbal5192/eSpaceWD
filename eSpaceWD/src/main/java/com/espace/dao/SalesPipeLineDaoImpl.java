package com.espace.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.SimpleFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.espace.entity.CustomerEntity;
import com.espace.model.SalesPipeLine;
import com.espace.model.Warehouse;


@Repository ("salesPipeLineDao")
public class SalesPipeLineDaoImpl implements SalesPipeLineDao {
	
	
@Autowired 
WarehouseDao warehouseDao;

@Autowired 
CustomerDao customerDao; 

public PreparedStatement prepare;	
public ResultSet res;
public Connection con;


public SalesPipeLineDaoImpl() throws SQLException, ClassNotFoundException
{
	String url="jdbc:mysql://citiswd-mysql-iqbal.crr7bged4sau.ap-south-1.rds.amazonaws.com:3306/citi_espace?autoReconnect=true";
	String userId="Iqbal";
	String pwd="Iqubal5192#me";
	Class.forName("com.mysql.jdbc.Driver");	
	con = DriverManager.getConnection(url, userId, pwd);
	
		
}

	public String addSalesPipeLine(String customerName, String customerType,Integer estimatedFloorBuiltupArea,
			Integer estimatedFloorCarpetArea, Integer estimatedRackBuiltupArea, Integer estimated_palette_positions,
			Date estimatedStartDate, Double estimatedRevenue,String allocatedWarehouse, String statusWork,String remarks) {
		

		//Converting util Date to sql Date
		
	    java.sql.Date startDate = new java.sql.Date(estimatedStartDate.getTime());

	    Date currentDate = new Date();
	    java.sql.Date currentSqlDate = new java.sql.Date(currentDate.getTime());
	    
	    String isActive="Yes";
		String isDeleted="No";
		Double actualRevenue = 0.0;	
		try{
					
					String insertTableSQL = "INSERT INTO salespipeline_master (customer_name, customer_type,estimated_floor_builtup, estimated_floor_carpet, estimated_rack_builtup, estimated_palette_positions, estimated_start_date,expectedRevenue, warehouse_id, status_id, isActive, isDeleted,actualRevenue,remarks,date_of_creation) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                   
					
					prepare=con.prepareStatement(insertTableSQL);
					prepare.setString(1, customerName);
					prepare.setString(2, customerType);
					prepare.setInt(3, estimatedFloorBuiltupArea);
					prepare.setInt(4, estimatedFloorCarpetArea);
					prepare.setInt(5, estimatedRackBuiltupArea);
					prepare.setInt(6, estimated_palette_positions);
					prepare.setDate(7, startDate);
					prepare.setDouble(8, estimatedRevenue);
                    prepare.setInt(9, Integer.parseInt(allocatedWarehouse));
                    prepare.setString(10, statusWork);
					prepare.setString(11, isActive);
					prepare.setString(12, isDeleted);
					prepare.setDouble(13, actualRevenue);
					prepare.setString(14,remarks);
					prepare.setDate(15,currentSqlDate);
					prepare.executeUpdate();
		
					
					return "successful";
					
		} 
				catch (Exception e) {
	      e.printStackTrace();
	    }
				return "failed";
		
		
		
	}

	public String updateSalesPipeLine(Integer salesPipeLineId, String customerName,String customerType,Integer availableFloor,Integer availableRack, Integer estimatedFloorBuiltupArea,
			Integer estimatedFloorCarpetArea, Integer estimatedRackBuiltupArea, Integer estimated_palette_positions,
			Date estimatedStartDate,Double estimatedRevenue, String allocatedWarehouse, String statusWork, Integer actualFloorBuiltupArea,
			Integer actualFloorCarpetArea,Integer actualFloorCarpetAreaRef,Integer actualRackBuiltupAreaRef, Integer actualRackBuiltupArea, Integer actual_palette_positions,
			Date actualStartDate,Double actualRevenue, String remark) {
		
		
//Converting util Date to sql Date
		
	    java.sql.Date startDate = new java.sql.Date(estimatedStartDate.getTime());
	    java.sql.Date finalStartDate = new java.sql.Date(actualStartDate.getTime());
	
	    String spaceAvialabilityStatus ="";
		Integer warehouseId = Integer.parseInt(allocatedWarehouse);
		
		
		if(actualFloorCarpetAreaRef == 0 || actualRackBuiltupAreaRef == 0)
		{
			Integer newAvailableFloor = availableFloor - actualFloorBuiltupArea;
			Integer newAvailableRack = availableRack - actualRackBuiltupArea;
		 spaceAvialabilityStatus = warehouseDao.updateSpaceAvialabilityWarehouse(warehouseId, newAvailableFloor, newAvailableRack);
		}
		else
		{
		 spaceAvialabilityStatus = warehouseDao.updateSpaceAvialabilityWarehouse(warehouseId, availableFloor, availableRack);
			
			
		}
		
   
	   
		
	    
	    if(spaceAvialabilityStatus.equals("successful"))
	    {
	    	
		
		try{
		 
		
	String insertTableSQL = "UPDATE salespipeline_master SET customer_name=?, customer_type=?,estimated_floor_builtup=?, estimated_floor_carpet=?, estimated_rack_builtup=?, estimated_palette_positions=?, estimated_start_date=?,expectedRevenue=?, warehouse_id=?, status_id=?, actual_floor_builtup=?, actual_floor_carpet=?, actual_rack_builtup=?, actual_palette_positions=?, actual_start_date=?,actualRevenue=?, remarks=?  WHERE sp_id = ?";
	       
			
			prepare=con.prepareStatement(insertTableSQL);
			prepare.setString(1, customerName);
			prepare.setString(2, customerType);
			prepare.setInt(3, estimatedFloorBuiltupArea);
			prepare.setInt(4, estimatedFloorCarpetArea);
			prepare.setInt(5, estimatedRackBuiltupArea);
			prepare.setInt(6, estimated_palette_positions);
			prepare.setDate(7, startDate);
			prepare.setDouble(8, estimatedRevenue);
            prepare.setInt(9, Integer.parseInt(allocatedWarehouse));
            prepare.setString(10, statusWork);
            prepare.setInt(11, actualFloorBuiltupArea);
			prepare.setInt(12, actualFloorCarpetArea);
			prepare.setInt(13, actualRackBuiltupArea);
			prepare.setInt(14, actual_palette_positions);
			prepare.setDate(15, finalStartDate);
			prepare.setDouble(16, actualRevenue);
            prepare.setString(17, remark);
            prepare.setInt(18,salesPipeLineId);
			prepare.executeUpdate();

			return statusWork;
		} 
				catch (Exception e) {
	      e.printStackTrace();
	    }
		 
				}
				return "failed";
		
		}

	public List<SalesPipeLine> listSalesPipeLine() {

		

		Integer salesPipeLineId;
		String customerName,customerNameValue;
		String customerType;
		Integer estimatedFloorBuiltupArea;
		Integer estimatedFloorCarpetArea;
		Integer estimatedRackBuiltupArea;
		Integer estimated_palette_positions;
		Date estimatedStartDate ;
		String allocatedWarehouse ;
		String statusWork ;
		Integer actualFloorBuiltupArea;
		Integer actualFloorCarpetArea;
		Integer actualRackBuiltupArea;
		Integer actual_palette_positions;
		Date actualStartDate;
		String remark;
		String warehouseName;
		Integer warehouseID;
		List<CustomerEntity> customerList;
		
		List<SalesPipeLine> salesArrayList=new ArrayList<SalesPipeLine>();
		SalesPipeLine salesPipeLine = null;
		try{		        	
			
			PreparedStatement prepare=con.prepareStatement("select sp_id,customer_name,customer_type,estimated_floor_builtup, estimated_floor_carpet, estimated_rack_builtup, estimated_palette_positions, estimated_start_date, warehouse_id, status_id, actual_floor_builtup, actual_floor_carpet, actual_rack_builtup, actual_palette_positions, actual_start_date, remarks from salespipeline_master where isActive='Yes' and isDeleted='No' and status_id != 'billable'");
            res=prepare.executeQuery();
			
			
			
			while(res.next())
			{
				salesPipeLineId=res.getInt("sp_id");
				customerName = res.getString("customer_name");
				customerType= res.getString("customer_type");
				estimatedFloorBuiltupArea = res.getInt("estimated_floor_builtup");
				estimatedFloorCarpetArea = res.getInt("estimated_floor_carpet");
				estimatedRackBuiltupArea = res.getInt("estimated_rack_builtup");
				estimated_palette_positions = res.getInt("estimated_palette_positions");
				estimatedStartDate = res.getDate("estimated_start_date");
				allocatedWarehouse = res.getString("warehouse_id");
				statusWork = res.getString("status_id");
				actualFloorBuiltupArea = res.getInt("actual_floor_builtup");
				actualFloorCarpetArea = res.getInt("actual_floor_carpet");
				actualRackBuiltupArea = res.getInt("actual_rack_builtup");
				actual_palette_positions = res.getInt("actual_palette_positions");
				actualStartDate = res.getDate("actual_start_date");
				remark = res.getString("remarks");
				
				warehouseName = warehouseDao.getWarehouseName(Integer.parseInt(allocatedWarehouse));
				warehouseID = Integer.parseInt(allocatedWarehouse);
				customerNameValue = "";
				customerList = customerDao.getCustomerById(Integer.parseInt(customerName));
				
				for (int k = 0; k < customerList.size(); k++) {  
					
					customerNameValue = nvl(customerList.get(k).getCustomer_name());
					
				}
				
				String statusNew = null;
				if(statusWork.equals("confirmed"))
				{
					statusNew = "Agreement Signed";
					
				}
				if(statusWork.equals("wIP"))
				{
					
					statusNew = "Work In Progress";
				}
				
				
				
				salesPipeLine = new SalesPipeLine();
				salesPipeLine.setSalesPipeLineId(salesPipeLineId);
			    salesPipeLine.setCustomerName(customerNameValue);
			    salesPipeLine.setCustomerType(customerType);
			    salesPipeLine.setEstimatedFloorBuiltupArea(estimatedFloorBuiltupArea);
			    salesPipeLine.setEstimatedFloorCarpetArea(estimatedFloorCarpetArea);
			    salesPipeLine.setEstimatedRackBuiltupArea(estimatedRackBuiltupArea);
			    salesPipeLine.setEstimated_palette_positions(estimated_palette_positions);
			    salesPipeLine.setEstimatedStartDate(estimatedStartDate);
			    salesPipeLine.setSalesPipeLineId(salesPipeLineId);
			    salesPipeLine.setAllocatedWarehouse(warehouseName);
			    salesPipeLine.setStatusWork(statusWork);
			    salesPipeLine.setActualFloorBuiltupArea(actualFloorBuiltupArea);
			    salesPipeLine.setActualFloorCarpetArea(actualFloorCarpetArea);
			    salesPipeLine.setActualRackBuiltupArea(actualRackBuiltupArea);
			    salesPipeLine.setActual_palette_positions(actual_palette_positions);
			    salesPipeLine.setRemark(remark);
			    salesPipeLine.setWarehouseId(warehouseID);
			    salesPipeLine.setStatusNew(statusNew);
			    salesArrayList.add(salesPipeLine);
				
				
			}

           
		} 
				catch (Exception e) {
	      e.printStackTrace();
	    }
	  
			
		return salesArrayList;
		
		
		
		
	}

	public HashMap<String, String> getSalesPipeLineDetailsById(Integer salesPipeLineId) {
		
		
		String salePLId;
		String customerName;
		String customerType;
		String estimatedFloorBuiltupArea;
		String estimatedFloorCarpetArea;
		String estimatedRackBuiltupArea;
		String estimated_palette_positions;
		String estimatedStartDate ;
		String estimatedRevenue ;
		String allocatedWarehouse ;
		String statusWork ;
		String actualFloorBuiltupArea;
		String actualFloorCarpetArea;
		String actualRackBuiltupArea;
		String actual_palette_positions;
		String actualStartDate;
		String actualRevenue;
		String remark;
		
		
		 HashMap<String, String> outputList= new HashMap<String, String>();
				try{
					
					
					prepare=con.prepareStatement("select customer_name,customer_type, estimated_floor_builtup, estimated_floor_carpet, estimated_rack_builtup, estimated_palette_positions, estimated_start_date,expectedRevenue, warehouse_id, status_id, actual_floor_builtup, actual_floor_carpet, actual_rack_builtup, actual_palette_positions, actual_start_date,actualRevenue, remarks from salespipeline_master where sp_id=?");
		            prepare.setInt(1, salesPipeLineId);

					res=prepare.executeQuery();
					
				      while(res.next()){
				          //Retrieve by column name
				    	  	salePLId = String.valueOf(salesPipeLineId);
				    	  	customerName = res.getString("customer_name");
				    	  	customerType = res.getString("customer_type"); 
							estimatedFloorBuiltupArea = String.valueOf(res.getInt("estimated_floor_builtup"));
							estimatedFloorCarpetArea = String.valueOf(res.getInt("estimated_floor_carpet"));
							estimatedRackBuiltupArea = String.valueOf(res.getInt("estimated_rack_builtup"));
							estimated_palette_positions = String.valueOf(res.getInt("estimated_palette_positions"));
							estimatedStartDate =  String.valueOf(res.getDate("estimated_start_date"));
							estimatedRevenue =  res.getString("expectedRevenue");
							allocatedWarehouse = res.getString("warehouse_id");
							statusWork = res.getString("status_id");
							actualFloorBuiltupArea = String.valueOf(res.getInt("actual_floor_builtup"));
							actualFloorCarpetArea = String.valueOf(res.getInt("actual_floor_carpet"));
							actualRackBuiltupArea = String.valueOf(res.getInt("actual_rack_builtup"));
							actual_palette_positions = String.valueOf(res.getInt("actual_palette_positions"));
							actualStartDate =  String.valueOf(res.getDate("actual_start_date"));
							actualRevenue = res.getString("actualRevenue");
							remark = res.getString("remarks");
				    	  
						  outputList.put("salePLId", salePLId);
				    	  outputList.put("customerName", customerName);
				    	  outputList.put("customerType", customerType);
				    	  outputList.put("estimatedFloorBuiltupArea", estimatedFloorBuiltupArea);
				    	  outputList.put("estimatedFloorCarpetArea",estimatedFloorCarpetArea);
				    	  outputList.put("estimatedRackBuiltupArea",estimatedRackBuiltupArea);
				    	  outputList.put("estimated_palette_positions",estimated_palette_positions);
				    	  outputList.put("estimatedStartDate", estimatedStartDate);
				    	  outputList.put("estimatedRevenue", estimatedRevenue);
				    	  outputList.put("allocatedWarehouse", allocatedWarehouse);
				    	  outputList.put("statusWork", statusWork);
				    	  outputList.put("actualFloorBuiltupArea",actualFloorBuiltupArea);
				    	  outputList.put("actualFloorCarpetArea",actualFloorCarpetArea);
				    	  outputList.put("actualRackBuiltupArea",actualRackBuiltupArea);
				    	  outputList.put("actual_palette_positions",actual_palette_positions);
				    	  outputList.put("actualStartDate", actualStartDate);
				    	  outputList.put("actualRevenue", actualRevenue);
				    	  outputList.put("remarks", remark);
					    	 
				    
							
				    	  
				       }
    
				     
                  
				}
		       catch(Exception e)
		    {
		    	   System.out.println(e);
		    	    
		    }
				
				
				return outputList;
		
		
		
		
		
	}

	public String getCustomerNameById(Integer salesPipeLineId) {
		


		String customerName = null;
		
		 
				try{
					
					prepare=con.prepareStatement("select customer_name from salespipeline_master where sp_id=?");
		            prepare.setInt(1, salesPipeLineId);

					res=prepare.executeQuery();
					
				      while(res.next()){
				    	  
				     	  customerName = res.getString("customer_name");
				       }
    
				       res.close();
                  
				}
		       catch(Exception e)
		    {
		    	   System.out.println(e);
		    	    
		    }
				
				
				return customerName;
		
		
		
		
		
		
		
	}

	public String deleteSalesPipeLine(Integer salesPipeLineId,Integer warehouseId,Integer estimatedFloorCarpetArea, Integer estimatedRackBuiltupArea) {
		
		
		try{
			
			String isActive="No";
			String isDeleted="Yes";		
			Integer floorCarpetArea = null;
			Integer rackArea = null;
			Integer rackAvailableArea = null;
			prepare=con.prepareStatement("select available_floor_carpet_area,available_rack_carpet_area from warehouse_master where warehouse_id=?");
            prepare.setInt(1, warehouseId);

			res=prepare.executeQuery();
			
		      while(res.next()){
		          //Retrieve by column name
		    	  floorCarpetArea = res.getInt("available_floor_carpet_area");
		    	  rackArea = res.getInt("available_rack_carpet_area");
			  }
			
		      floorCarpetArea = estimatedFloorCarpetArea + floorCarpetArea;
		      rackAvailableArea = estimatedRackBuiltupArea + rackArea;
			
	        String insertTableSQL = "UPDATE salespipeline_master SET isActive=?, isDeleted=?  WHERE sp_id = ?";
	  
		//String insertTable = "UPDATE salespipeline_master sales INNER JOIN warehouse_master warehouse ON (sales.warehouse_id = warehouse.warehouse_id) SET  sales.isActive=?, sales.isDeleted=?, warehouse.available_floor_carpet_area= ? WHERE sales.sp_id = ? AND warehouse.warehouse_id = ? ";	
			
			prepare=con.prepareStatement(insertTableSQL);
			prepare.setString(1, isActive);
			prepare.setString(2, isDeleted);
			prepare.setInt(3, salesPipeLineId);
			prepare.executeUpdate();
			
			
			PreparedStatement prepareSt=con.prepareStatement("UPDATE warehouse_master SET available_floor_carpet_area=?,available_rack_carpet_area=?  WHERE warehouse_id = ?");
            prepareSt.setInt(1, floorCarpetArea);
            prepareSt.setInt(2, rackAvailableArea);
			prepareSt.setInt(3, warehouseId);
			prepareSt.executeUpdate();

			
			return "successful";
		} 
				catch (Exception e) {
	      e.printStackTrace();
	    }
		
				
		return "failure";
		
		
		
	}
	
	
	public List<SalesPipeLine> ageReportController(String statusWorkCondition) {

		

		Integer salesPipeLineId;
		String customerName,customerNameValue;
		Integer estimatedFloorBuiltupArea;
		List<CustomerEntity> customerList;
		Date estimatedStartDate ;
		String allocatedWarehouse,warehouseName;
		String statusWork;
		Date dateOfCreationSql;
		
		List<SalesPipeLine> salesArrayList=new ArrayList<SalesPipeLine>();
		SalesPipeLine salesPipeLine = null;
		ResultSet res;
		try{		        	
			
			PreparedStatement prepare=con.prepareStatement("select sp_id,customer_name, estimated_floor_builtup,status_id,date_of_creation, warehouse_id,estimated_start_date from salespipeline_master where isActive='Yes' and isDeleted='No' and status_id=? ");
			  prepare.setString(1, statusWorkCondition);
			  res=prepare.executeQuery();
			
			
			
			while(res.next())
			{
				salesPipeLineId=res.getInt("sp_id");
				customerName = res.getString("customer_name");
				estimatedFloorBuiltupArea = res.getInt("estimated_floor_builtup");
				statusWork = res.getString("status_id");
				dateOfCreationSql = res.getDate("date_of_creation");
				estimatedStartDate = res.getDate("estimated_start_date");
				allocatedWarehouse = res.getString("warehouse_id");
				
				Date date = new Date();
				
				long diff = Math.abs(estimatedStartDate.getTime() - date.getTime());
				long age = diff / (24 * 60 * 60 * 1000);
				
				warehouseName = warehouseDao.getWarehouseName(Integer.parseInt(allocatedWarehouse));
				
				if(statusWork.equals("wIP"))
				{
					statusWork = "Work In Progress";					
				}
				
				customerNameValue = "";
				customerList = customerDao.getCustomerById(Integer.parseInt(customerName));
				
				for (int k = 0; k < customerList.size(); k++) {  
					
					customerNameValue = nvl(customerList.get(k).getCustomer_name());
					
				}
				
				//Date Of Creation
				SimpleDateFormat sc=new SimpleDateFormat("dd-MM-yyyy");
				String dateOfCreation = sc.format(dateOfCreationSql); 
				
				salesPipeLine = new SalesPipeLine();
				salesPipeLine.setSalesPipeLineId(salesPipeLineId);
			    salesPipeLine.setCustomerName(customerNameValue);
			    salesPipeLine.setEstimatedFloorBuiltupArea(estimatedFloorBuiltupArea);
			    salesPipeLine.setStatusWork(statusWork);
			    salesPipeLine.setDateOfCreation(dateOfCreation);
			    salesPipeLine.setSalesPipeLineId(salesPipeLineId);
			    salesPipeLine.setAllocatedWarehouse(warehouseName);
			    salesPipeLine.setAge(age);
			    salesArrayList.add(salesPipeLine);
				
				
			}

           
		} 
				catch (Exception e) {
	      e.printStackTrace();
	    }
		
			
		return salesArrayList;
		
		
		
		
	}
	
	
public List<SalesPipeLine> areaReportController(String clientStatusFilter) {

		

		Integer salesPipeLineId;
		String customerName,customerNameValue;
		List<CustomerEntity> customerList;
		Integer estimatedFloorBuiltupArea;
		Integer actualFloorBuiltupArea;
		Integer estimatedFloorCarpetArea;
		Integer actualFloorCarpetArea;
		Integer actualRackBuiltUp;
		Date estimatedStartDate ;
		Date dateOfCreationSql;
		String allocatedWarehouse ;
		String statusWork;
		String isActive;
		String isDeleted;
		
		List<SalesPipeLine> salesArrayList=new ArrayList<SalesPipeLine>();
		SalesPipeLine salesPipeLine = null;
		ResultSet res;
		try{		        	
			
			PreparedStatement prepare=con.prepareStatement("select sp_id,customer_name, estimated_floor_builtup,actual_floor_builtup, estimated_floor_carpet, actual_floor_carpet, status_id,estimated_start_date, warehouse_id,isActive,isDeleted,date_of_creation,actual_rack_builtup from salespipeline_master where isActive='Yes' and isDeleted='No' and status_id=?");
			prepare.setString(1, clientStatusFilter);
			res=prepare.executeQuery();
			
			
			
			while(res.next())
			{
				salesPipeLineId=res.getInt("sp_id");
				customerName = res.getString("customer_name");
				estimatedFloorBuiltupArea = res.getInt("estimated_floor_builtup");
				actualFloorBuiltupArea = res.getInt("actual_floor_builtup");
				estimatedFloorCarpetArea = res.getInt("estimated_floor_carpet");
				actualFloorCarpetArea = res.getInt("actual_floor_carpet");
				statusWork = res.getString("status_id");
				estimatedStartDate = res.getDate("estimated_start_date");
				dateOfCreationSql = res.getDate("date_of_creation");
				actualRackBuiltUp = res.getInt("actual_rack_builtup");
				allocatedWarehouse = res.getString("warehouse_id");
				isActive = res.getString("isActive");
				isDeleted = res.getString("isDeleted");
				Date date = new Date();
				
				long diff = Math.abs(estimatedStartDate.getTime() - date.getTime());
				long age = diff / (24 * 60 * 60 * 1000);
				
				String statusNew = null;
				if(statusWork.equals("confirmed"))
				{
					statusNew = "Agreement Signed";
					
				}
				if(statusWork.equals("wIP"))
				{
					
					statusNew = "Work In Progress";
				}
				
				if(statusWork.equals("billable"))
				{
					
					statusNew = "Billable";
					
				}
				
				customerNameValue = "";
				customerList = customerDao.getCustomerById(Integer.parseInt(customerName));
				
				for (int k = 0; k < customerList.size(); k++) {  
					
					customerNameValue = nvl(customerList.get(k).getCustomer_name());
					
				}
				
				//Total Sellable area 
				Integer sellableArea = actualRackBuiltUp + actualFloorBuiltupArea;
				
				//Date Of Creation
				SimpleDateFormat sc=new SimpleDateFormat("dd-MM-yyyy");
				String dateOfCreation = sc.format(dateOfCreationSql); 
				
				
				salesPipeLine = new SalesPipeLine();
				salesPipeLine.setSalesPipeLineId(salesPipeLineId);
			    salesPipeLine.setCustomerName(customerNameValue);
			    salesPipeLine.setEstimatedFloorBuiltupArea(estimatedFloorBuiltupArea);
			    salesPipeLine.setActualFloorBuiltupArea(actualFloorBuiltupArea);
			    salesPipeLine.setEstimatedFloorCarpetArea(estimatedFloorCarpetArea);
			    salesPipeLine.setActualFloorCarpetArea(actualFloorCarpetArea);
			    salesPipeLine.setStatusNew(statusNew);
			    salesPipeLine.setEstimatedStartDate(estimatedStartDate);
			    salesPipeLine.setDateOfCreation(dateOfCreation);
			    salesPipeLine.setSalesPipeLineId(salesPipeLineId);
			    salesPipeLine.setAllocatedWarehouse(allocatedWarehouse);
			    salesPipeLine.setAge(age);
			    salesPipeLine.setTotalSellableArea(sellableArea);
			    salesPipeLine.setIsActive(isActive);
			    salesPipeLine.setIsDeleted(isDeleted);
			    salesArrayList.add(salesPipeLine);
				
				
			}

           
		} 
				catch (Exception e) {
	      e.printStackTrace();
	    }
		
			
		return salesArrayList;
		
		
		
		
	}


public List<SalesPipeLine> clientReportController(Integer clientWarehouseFilter) {

	

	Integer salesPipeLineId;
	String customerName,customerNameValue;
	List<CustomerEntity> customerList;
	Integer estimatedFloorBuiltupArea;
	Integer actualFloorBuiltupArea;
	Integer estimatedFloorCarpetArea;
	Integer actualFloorCarpetArea;
	Date estimatedStartDate ;
	String allocatedWarehouse ;
	String statusWork;
	String isActive;
	String isDeleted;
	Integer expectedRevenue;
	Integer actualRevenue;
	Integer actualRackBuiltUp;
	
	List<SalesPipeLine> salesArrayList=new ArrayList<SalesPipeLine>();
	SalesPipeLine salesPipeLine = null;
	ResultSet res;
	try{		        	
		
		PreparedStatement prepare=con.prepareStatement("select sp_id,customer_name, estimated_floor_builtup,actual_floor_builtup, estimated_floor_carpet, actual_floor_carpet, status_id,estimated_start_date, warehouse_id,isActive,isDeleted,expectedRevenue,actualRevenue,actual_rack_builtup from salespipeline_master where isActive='Yes' and isDeleted='No' and warehouse_id=?");
        prepare.setInt(1, clientWarehouseFilter);
		res=prepare.executeQuery();
		
		
		
		while(res.next())
		{
			salesPipeLineId=res.getInt("sp_id");
			customerName = res.getString("customer_name");
			estimatedFloorBuiltupArea = res.getInt("estimated_floor_builtup");
			actualFloorBuiltupArea = res.getInt("actual_floor_builtup");
			estimatedFloorCarpetArea = res.getInt("estimated_floor_carpet");
			actualFloorCarpetArea = res.getInt("actual_floor_carpet");
			statusWork = res.getString("status_id");
			estimatedStartDate = res.getDate("estimated_start_date");
			allocatedWarehouse = res.getString("warehouse_id");
			isActive = res.getString("isActive");
			isDeleted = res.getString("isDeleted");
			expectedRevenue = res.getInt("expectedRevenue");
			actualRevenue = res.getInt("actualRevenue");
			actualRackBuiltUp = res.getInt("actual_rack_builtup");
			Date date = new Date();
			
			long diff = Math.abs(estimatedStartDate.getTime() - date.getTime());
			long age = diff / (24 * 60 * 60 * 1000);
			
			String statusNew = null;
			if(statusWork.equals("confirmed"))
			{
				statusNew = "Agreement Signed";
				
			}
			if(statusWork.equals("wIP"))
			{
				
				statusNew = "Work In Progress";
			}
			
			if(statusWork.equals("billable"))
			{
				
				statusNew = "Billable";
				
			}
			
			customerNameValue = "";
			customerList = customerDao.getCustomerById(Integer.parseInt(customerName));
			
			for (int k = 0; k < customerList.size(); k++) {  
				
				customerNameValue = nvl(customerList.get(k).getCustomer_name());
				
			}
			
			Integer sellableArea = actualRackBuiltUp + actualFloorBuiltupArea;
			
			salesPipeLine = new SalesPipeLine();
			salesPipeLine.setSalesPipeLineId(salesPipeLineId);
		    salesPipeLine.setCustomerName(customerNameValue);
		    salesPipeLine.setEstimatedFloorBuiltupArea(estimatedFloorBuiltupArea);
		    salesPipeLine.setActualFloorBuiltupArea(actualFloorBuiltupArea);
		    salesPipeLine.setEstimatedFloorCarpetArea(estimatedFloorCarpetArea);
		    salesPipeLine.setActualFloorCarpetArea(actualFloorCarpetArea);
		    salesPipeLine.setStatusNew(statusNew);
		    salesPipeLine.setEstimatedStartDate(estimatedStartDate);
		    salesPipeLine.setSalesPipeLineId(salesPipeLineId);
		    salesPipeLine.setAllocatedWarehouse(allocatedWarehouse);
		    salesPipeLine.setAge(age);
		    salesPipeLine.setIsActive(isActive);
		    salesPipeLine.setIsDeleted(isDeleted);
		    salesPipeLine.setExpectedRevenue(expectedRevenue);
		    salesPipeLine.setActualRevenue(actualRevenue);
		    salesPipeLine.setTotalSellableArea(sellableArea);
		    salesArrayList.add(salesPipeLine);
			
			
		}

       
	} 
			catch (Exception e) {
      e.printStackTrace();
    }
	
		
	return salesArrayList;
	
	
	
	
}


	
public List<String> chartSalesPipeLine() {

		

		
		String warehouse_name;
		
		
		
		List<String> salesArrayList=new ArrayList<String>();
		
		try{		        	
			
			PreparedStatement prepare=con.prepareStatement("select warehouse_name from warehouse_master where isActive='Yes' and isDeleted='No'");
            res=prepare.executeQuery();
			
			
			
			while(res.next())
			{
				
				warehouse_name = res.getString("warehouse_name");
				 salesArrayList.add(warehouse_name);
				
				
			}

           
		} 
				catch (Exception e) {
	      e.printStackTrace();
	    }
	  
			
		return salesArrayList;
		
		
		
		
	}
	

public static String nvl(String str) {
    return (str == null) ? "" : str.trim();
}

public List<SalesPipeLine> listSalesPipeLineByStatus(String status) {
	
	

	Integer salesPipeLineId;
	String customerName,customerNameValue;
	String customerType;
	Integer estimatedFloorBuiltupArea;
	Integer estimatedFloorCarpetArea;
	Integer estimatedRackBuiltupArea;
	Integer estimated_palette_positions;
	Date estimatedStartDate ;
	String allocatedWarehouse ;
	String statusWork ;
	Integer actualFloorBuiltupArea;
	Integer actualFloorCarpetArea;
	Integer actualRackBuiltupArea;
	Integer actual_palette_positions;
	Date actualStartDate;
	String remark;
	String warehouseName;
	Integer warehouseID;
	List<CustomerEntity> customerList;
	
	List<SalesPipeLine> salesArrayList=new ArrayList<SalesPipeLine>();
	SalesPipeLine salesPipeLine = null;
	try{		        	
		
		PreparedStatement prepare=con.prepareStatement("select sp_id,customer_name,customer_type,estimated_floor_builtup, estimated_floor_carpet, estimated_rack_builtup, estimated_palette_positions, estimated_start_date, warehouse_id, status_id, actual_floor_builtup, actual_floor_carpet, actual_rack_builtup, actual_palette_positions, actual_start_date, remarks from salespipeline_master where isActive='Yes' and isDeleted='No' and status_id = ?");
		prepare.setString(1, status);
		res=prepare.executeQuery();
		
		
		
		while(res.next())
		{
			salesPipeLineId=res.getInt("sp_id");
			customerName = res.getString("customer_name");
			customerType= res.getString("customer_type");
			estimatedFloorBuiltupArea = res.getInt("estimated_floor_builtup");
			estimatedFloorCarpetArea = res.getInt("estimated_floor_carpet");
			estimatedRackBuiltupArea = res.getInt("estimated_rack_builtup");
			estimated_palette_positions = res.getInt("estimated_palette_positions");
			estimatedStartDate = res.getDate("estimated_start_date");
			allocatedWarehouse = res.getString("warehouse_id");
			statusWork = res.getString("status_id");
			actualFloorBuiltupArea = res.getInt("actual_floor_builtup");
			actualFloorCarpetArea = res.getInt("actual_floor_carpet");
			actualRackBuiltupArea = res.getInt("actual_rack_builtup");
			actual_palette_positions = res.getInt("actual_palette_positions");
			actualStartDate = res.getDate("actual_start_date");
			remark = res.getString("remarks");
			
			warehouseName = warehouseDao.getWarehouseName(Integer.parseInt(allocatedWarehouse));
			warehouseID = Integer.parseInt(allocatedWarehouse);
			customerNameValue = "";
			customerList = customerDao.getCustomerById(Integer.parseInt(customerName));
			
			for (int k = 0; k < customerList.size(); k++) {  
				
				customerNameValue = nvl(customerList.get(k).getCustomer_name());
				
			}
			
			String statusNew = null;
			if(statusWork.equals("confirmed"))
			{
				statusNew = "Agreement Signed";
				
			}
			if(statusWork.equals("wIP"))
			{
				
				statusNew = "Work In Progress";
			}
			if(statusWork.equals("billable"))
			{
				
				statusNew = "Billable";
				
			}
			
			
			
			salesPipeLine = new SalesPipeLine();
			salesPipeLine.setSalesPipeLineId(salesPipeLineId);
		    salesPipeLine.setCustomerName(customerNameValue);
		    salesPipeLine.setCustomerType(customerType);
		    salesPipeLine.setEstimatedFloorBuiltupArea(estimatedFloorBuiltupArea);
		    salesPipeLine.setEstimatedFloorCarpetArea(estimatedFloorCarpetArea);
		    salesPipeLine.setEstimatedRackBuiltupArea(estimatedRackBuiltupArea);
		    salesPipeLine.setEstimated_palette_positions(estimated_palette_positions);
		    salesPipeLine.setEstimatedStartDate(estimatedStartDate);
		    salesPipeLine.setSalesPipeLineId(salesPipeLineId);
		    salesPipeLine.setAllocatedWarehouse(warehouseName);
		    salesPipeLine.setStatusWork(statusWork);
		    salesPipeLine.setActualFloorBuiltupArea(actualFloorBuiltupArea);
		    salesPipeLine.setActualFloorCarpetArea(actualFloorCarpetArea);
		    salesPipeLine.setActualRackBuiltupArea(actualRackBuiltupArea);
		    salesPipeLine.setActual_palette_positions(actual_palette_positions);
		    salesPipeLine.setRemark(remark);
		    salesPipeLine.setWarehouseId(warehouseID);
		    salesPipeLine.setStatusNew(statusNew);
		    salesArrayList.add(salesPipeLine);
			
			
		}

       
	} 
			catch (Exception e) {
      e.printStackTrace();
    }
  
		
	return salesArrayList;
	

	
	
}
	
		
		}
