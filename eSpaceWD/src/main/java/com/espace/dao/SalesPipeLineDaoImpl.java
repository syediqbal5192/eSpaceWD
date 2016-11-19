package com.espace.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.espace.model.SalesPipeLine;
import com.espace.model.Warehouse;


@Repository ("salesPipeLineDao")
public class SalesPipeLineDaoImpl implements SalesPipeLineDao {
	
	
@Autowired 
WarehouseDao warehouseDao;
public PreparedStatement prepare;	
public ResultSet res;
public Connection con;


public SalesPipeLineDaoImpl() throws SQLException, ClassNotFoundException
{
	String url="jdbc:mysql://citiswd-mysql-iqbal.crr7bged4sau.ap-south-1.rds.amazonaws.com:3306/citi_espace";
	String userId="Iqbal";
	String pwd="Iqubal5192#me";
	Class.forName("com.mysql.jdbc.Driver");	
	con = DriverManager.getConnection(url, userId, pwd);
	
		
}

	public String addSalesPipeLine(String customerName, Integer estimatedFloorBuiltupArea,
			Integer estimatedFloorCarpetArea, Integer estimatedRackBuiltupArea, Integer estimatedRackCarpetArea,
			Date estimatedStartDate, Double estimatedRevenue,String allocatedWarehouse, String statusWork) {
		

		//Converting util Date to sql Date
		
	    java.sql.Date startDate = new java.sql.Date(estimatedStartDate.getTime());
		
	    String isActive="Yes";
		String isDeleted="No";
		Double actualRevenue = 0.0;	
		try{
					
					String insertTableSQL = "INSERT INTO salespipeline_master (customer_name, estimated_floor_builtup, estimated_floor_carpet, estimated_rack_builtup, estimated_rack_carpet, estimated_start_date,expectedRevenue, warehouse_id, status_id, isActive, isDeleted,actualRevenue) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
                   
					
					prepare=con.prepareStatement(insertTableSQL);
					prepare.setString(1, customerName);
					prepare.setInt(2, estimatedFloorBuiltupArea);
					prepare.setInt(3, estimatedFloorCarpetArea);
					prepare.setInt(4, estimatedRackBuiltupArea);
					prepare.setInt(5, estimatedRackCarpetArea);
					prepare.setDate(6, startDate);
					prepare.setDouble(7, estimatedRevenue);
                    prepare.setInt(8, Integer.parseInt(allocatedWarehouse));
                    prepare.setString(9, statusWork);
					prepare.setString(10, isActive);
					prepare.setString(11, isDeleted);
					prepare.setDouble(12, actualRevenue);
					prepare.executeUpdate();
		
					
					return "successful";
					
		} 
				catch (Exception e) {
	      e.printStackTrace();
	    }
				return "failed";
		
		
		
	}

	public String updateSalesPipeLine(Integer salesPipeLineId, String customerName,Integer availableFloor,Integer availableRack, Integer estimatedFloorBuiltupArea,
			Integer estimatedFloorCarpetArea, Integer estimatedRackBuiltupArea, Integer estimatedRackCarpetArea,
			Date estimatedStartDate,Double estimatedRevenue, String allocatedWarehouse, String statusWork, Integer actualFloorBuiltupArea,
			Integer actualFloorCarpetArea, Integer actualRackBuiltupArea, Integer actualRackCarpetArea,
			Date actualStartDate,Double actualRevenue, String remark) {
		
		
//Converting util Date to sql Date
		
	    java.sql.Date startDate = new java.sql.Date(estimatedStartDate.getTime());
	    java.sql.Date finalStartDate = new java.sql.Date(actualStartDate.getTime());
	
		
		Integer warehouseId = Integer.parseInt(allocatedWarehouse);
		
		Integer newAvailableFloor = availableFloor - actualFloorCarpetArea;
		Integer newAvailableRack = availableFloor - actualRackCarpetArea;
   
	    String spaceAvialabilityStatus = warehouseDao.updateSpaceAvialabilityWarehouse(warehouseId, newAvailableFloor, newAvailableRack);
		
	    
	    if(spaceAvialabilityStatus.equals("successful"))
	    {
	    	
		
		try{
		 
		
	String insertTableSQL = "UPDATE salespipeline_master SET customer_name=?, estimated_floor_builtup=?, estimated_floor_carpet=?, estimated_rack_builtup=?, estimated_rack_carpet=?, estimated_start_date=?,expectedRevenue=?, warehouse_id=?, status_id=?, actual_floor_builtup=?, actual_floor_carpet=?, actual_rack_builtup=?, actual_rack_carpet=?, actual_start_date=?,actualRevenue=?, remarks=?  WHERE sp_id = ?";
	       
			
			prepare=con.prepareStatement(insertTableSQL);
			prepare.setString(1, customerName);
			prepare.setInt(2, estimatedFloorBuiltupArea);
			prepare.setInt(3, estimatedFloorCarpetArea);
			prepare.setInt(4, estimatedRackBuiltupArea);
			prepare.setInt(5, estimatedRackCarpetArea);
			prepare.setDate(6, startDate);
			prepare.setDouble(7, estimatedRevenue);
            prepare.setInt(8, Integer.parseInt(allocatedWarehouse));
            prepare.setString(9, statusWork);
            prepare.setInt(10, actualFloorBuiltupArea);
			prepare.setInt(11, actualFloorCarpetArea);
			prepare.setInt(12, actualRackBuiltupArea);
			prepare.setInt(13, actualRackCarpetArea);
			prepare.setDate(14, finalStartDate);
			prepare.setDouble(15, actualRevenue);
            prepare.setString(16, remark);
            prepare.setInt(17,salesPipeLineId);
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
		String customerName;
		Integer estimatedFloorBuiltupArea;
		Integer estimatedFloorCarpetArea;
		Integer estimatedRackBuiltupArea;
		Integer estimatedRackCarpetArea;
		Date estimatedStartDate ;
		String allocatedWarehouse ;
		String statusWork ;
		Integer actualFloorBuiltupArea;
		Integer actualFloorCarpetArea;
		Integer actualRackBuiltupArea;
		Integer actualRackCarpetArea;
		Date actualStartDate;
		String remark;
		String warehouseName;
		Integer warehouseID;
		
		List<SalesPipeLine> salesArrayList=new ArrayList<SalesPipeLine>();
		SalesPipeLine salesPipeLine = null;
		try{		        	
			
			PreparedStatement prepare=con.prepareStatement("select sp_id,customer_name, estimated_floor_builtup, estimated_floor_carpet, estimated_rack_builtup, estimated_rack_carpet, estimated_start_date, warehouse_id, status_id, actual_floor_builtup, actual_floor_carpet, actual_rack_builtup, actual_rack_carpet, actual_start_date, remarks from salespipeline_master where isActive='Yes' and isDeleted='No'");
            res=prepare.executeQuery();
			
			
			
			while(res.next())
			{
				salesPipeLineId=res.getInt("sp_id");
				customerName = res.getString("customer_name");
				estimatedFloorBuiltupArea = res.getInt("estimated_floor_builtup");
				estimatedFloorCarpetArea = res.getInt("estimated_floor_carpet");
				estimatedRackBuiltupArea = res.getInt("estimated_rack_builtup");
				estimatedRackCarpetArea = res.getInt("estimated_rack_carpet");
				estimatedStartDate = res.getDate("estimated_start_date");
				allocatedWarehouse = res.getString("warehouse_id");
				statusWork = res.getString("status_id");
				actualFloorBuiltupArea = res.getInt("actual_floor_builtup");
				actualFloorCarpetArea = res.getInt("actual_floor_carpet");
				actualRackBuiltupArea = res.getInt("actual_rack_builtup");
				actualRackCarpetArea = res.getInt("actual_rack_carpet");
				actualStartDate = res.getDate("actual_start_date");
				remark = res.getString("remarks");
				
				warehouseName = warehouseDao.getWarehouseName(Integer.parseInt(allocatedWarehouse));
				warehouseID = Integer.parseInt(allocatedWarehouse);
				
				
				salesPipeLine = new SalesPipeLine();
				salesPipeLine.setSalesPipeLineId(salesPipeLineId);
			    salesPipeLine.setCustomerName(customerName);
			    salesPipeLine.setEstimatedFloorBuiltupArea(estimatedFloorBuiltupArea);
			    salesPipeLine.setEstimatedFloorCarpetArea(estimatedFloorCarpetArea);
			    salesPipeLine.setEstimatedRackBuiltupArea(estimatedRackBuiltupArea);
			    salesPipeLine.setEstimatedRackCarpetArea(estimatedRackCarpetArea);
			    salesPipeLine.setEstimatedStartDate(estimatedStartDate);
			    salesPipeLine.setSalesPipeLineId(salesPipeLineId);
			    salesPipeLine.setAllocatedWarehouse(warehouseName);
			    salesPipeLine.setStatusWork(statusWork);
			    salesPipeLine.setActualFloorBuiltupArea(actualFloorBuiltupArea);
			    salesPipeLine.setActualFloorCarpetArea(actualFloorCarpetArea);
			    salesPipeLine.setActualRackBuiltupArea(actualRackBuiltupArea);
			    salesPipeLine.setActualRackCarpetArea(actualRackCarpetArea);
			    salesPipeLine.setRemark(remark);
			    salesPipeLine.setWarehouseId(warehouseID);
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
		String estimatedFloorBuiltupArea;
		String estimatedFloorCarpetArea;
		String estimatedRackBuiltupArea;
		String estimatedRackCarpetArea;
		String estimatedStartDate ;
		String estimatedRevenue ;
		String allocatedWarehouse ;
		String statusWork ;
		String actualFloorBuiltupArea;
		String actualFloorCarpetArea;
		String actualRackBuiltupArea;
		String actualRackCarpetArea;
		String actualStartDate;
		String actualRevenue;
		String remark;
		
		
		 HashMap<String, String> outputList= new HashMap<String, String>();
				try{
					
					
					prepare=con.prepareStatement("select customer_name, estimated_floor_builtup, estimated_floor_carpet, estimated_rack_builtup, estimated_rack_carpet, estimated_start_date,expectedRevenue, warehouse_id, status_id, actual_floor_builtup, actual_floor_carpet, actual_rack_builtup, actual_rack_carpet, actual_start_date,actualRevenue, remarks from salespipeline_master where sp_id=?");
		            prepare.setInt(1, salesPipeLineId);

					res=prepare.executeQuery();
					
				      while(res.next()){
				          //Retrieve by column name
				    	  salePLId = String.valueOf(salesPipeLineId);
				    	  customerName = res.getString("customer_name");
				    	
							estimatedFloorBuiltupArea = String.valueOf(res.getInt("estimated_floor_builtup"));
							estimatedFloorCarpetArea = String.valueOf(res.getInt("estimated_floor_carpet"));
							estimatedRackBuiltupArea = String.valueOf(res.getInt("estimated_rack_builtup"));
							estimatedRackCarpetArea = String.valueOf(res.getInt("estimated_rack_carpet"));
							estimatedStartDate =  String.valueOf(res.getDate("estimated_start_date"));
							estimatedRevenue =  res.getString("expectedRevenue");
							allocatedWarehouse = res.getString("warehouse_id");
							statusWork = res.getString("status_id");
							actualFloorBuiltupArea = String.valueOf(res.getInt("actual_floor_builtup"));
							actualFloorCarpetArea = String.valueOf(res.getInt("actual_floor_carpet"));
							actualRackBuiltupArea = String.valueOf(res.getInt("actual_rack_builtup"));
							actualRackCarpetArea = String.valueOf(res.getInt("actual_rack_carpet"));
							actualStartDate =  String.valueOf(res.getDate("actual_start_date"));
							actualRevenue = res.getString("actualRevenue");
							remark = res.getString("remarks");
				    	  
						  outputList.put("salePLId", salePLId);
				    	  outputList.put("customerName", customerName);
				    	  outputList.put("estimatedFloorBuiltupArea", estimatedFloorBuiltupArea);
				    	  outputList.put("estimatedFloorCarpetArea",estimatedFloorCarpetArea);
				    	  outputList.put("estimatedRackBuiltupArea",estimatedRackBuiltupArea);
				    	  outputList.put("estimatedRackCarpetArea",estimatedRackCarpetArea);
				    	  outputList.put("estimatedStartDate", estimatedStartDate);
				    	  outputList.put("estimatedRevenue", estimatedRevenue);
				    	  outputList.put("allocatedWarehouse", allocatedWarehouse);
				    	  outputList.put("statusWork", statusWork);
				    	  outputList.put("actualFloorBuiltupArea",actualFloorBuiltupArea);
				    	  outputList.put("actualFloorCarpetArea",actualFloorCarpetArea);
				    	  outputList.put("actualRackBuiltupArea",actualRackBuiltupArea);
				    	  outputList.put("actualRackCarpetArea",actualRackCarpetArea);
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

	public String deleteSalesPipeLine(Integer salesPipeLineId,Integer warehouseId,Integer estimatedFloorCarpetArea) {
		
		
		try{
			
			String isActive="No";
			String isDeleted="Yes";		
			Integer floorCarpetArea = null;
			prepare=con.prepareStatement("select available_floor_carpet_area from warehouse_master where warehouse_id=?");
            prepare.setInt(1, warehouseId);

			res=prepare.executeQuery();
			
		      while(res.next()){
		          //Retrieve by column name
		    	  floorCarpetArea = res.getInt("available_floor_carpet_area");
			  }
			
		      floorCarpetArea = estimatedFloorCarpetArea + floorCarpetArea;
			
	        String insertTableSQL = "UPDATE salespipeline_master SET isActive=?, isDeleted=?  WHERE sp_id = ?";
	  
		//String insertTable = "UPDATE salespipeline_master sales INNER JOIN warehouse_master warehouse ON (sales.warehouse_id = warehouse.warehouse_id) SET  sales.isActive=?, sales.isDeleted=?, warehouse.available_floor_carpet_area= ? WHERE sales.sp_id = ? AND warehouse.warehouse_id = ? ";	
			
			prepare=con.prepareStatement(insertTableSQL);
			prepare.setString(1, isActive);
			prepare.setString(2, isDeleted);
			prepare.setInt(3, salesPipeLineId);
			prepare.executeUpdate();
			
			prepare=con.prepareStatement("UPDATE warehouse_master SET available_floor_carpet_area=?  WHERE warehouse_id = ?");
            prepare.setInt(1, floorCarpetArea);
			prepare.setInt(2, warehouseId);
			prepare.executeUpdate();

			
			return "successful";
		} 
				catch (Exception e) {
	      e.printStackTrace();
	    }
		
				
		return "failure";
		
		
		
	}
	
	
	public List<SalesPipeLine> ageReportController() {

		

		Integer salesPipeLineId;
		String customerName;
		Integer estimatedFloorBuiltupArea;
		
		Date estimatedStartDate ;
		String allocatedWarehouse ;
		String statusWork;
		
		List<SalesPipeLine> salesArrayList=new ArrayList<SalesPipeLine>();
		SalesPipeLine salesPipeLine = null;
		ResultSet res;
		try{		        	
			
			PreparedStatement prepare=con.prepareStatement("select sp_id,customer_name, estimated_floor_builtup,status_id,estimated_start_date, warehouse_id from salespipeline_master where isActive='Yes' and isDeleted='No' and status_id='wIP' ");
            res=prepare.executeQuery();
			
			
			
			while(res.next())
			{
				salesPipeLineId=res.getInt("sp_id");
				customerName = res.getString("customer_name");
				estimatedFloorBuiltupArea = res.getInt("estimated_floor_builtup");
				statusWork = res.getString("status_id");
				estimatedStartDate = res.getDate("estimated_start_date");
				allocatedWarehouse = res.getString("warehouse_id");
				
				Date date = new Date();
				
				long diff = Math.abs(estimatedStartDate.getTime() - date.getTime());
				long age = diff / (24 * 60 * 60 * 1000);
				
				salesPipeLine = new SalesPipeLine();
				salesPipeLine.setSalesPipeLineId(salesPipeLineId);
			    salesPipeLine.setCustomerName(customerName);
			    salesPipeLine.setEstimatedFloorBuiltupArea(estimatedFloorBuiltupArea);
			    salesPipeLine.setStatusWork(statusWork);
			    salesPipeLine.setEstimatedStartDate(estimatedStartDate);
			    salesPipeLine.setSalesPipeLineId(salesPipeLineId);
			    salesPipeLine.setAllocatedWarehouse(allocatedWarehouse);
			    salesPipeLine.setAge(age);
			    salesArrayList.add(salesPipeLine);
				
				
			}

           
		} 
				catch (Exception e) {
	      e.printStackTrace();
	    }
		
			
		return salesArrayList;
		
		
		
		
	}
	
	
public List<SalesPipeLine> areaReportController() {

		

		Integer salesPipeLineId;
		String customerName;
		Integer estimatedFloorBuiltupArea;
		Integer actualFloorBuiltupArea;
		Integer estimatedFloorCarpetArea;
		Integer actualFloorCarpetArea;
		Date estimatedStartDate ;
		String allocatedWarehouse ;
		String statusWork;
		String isActive;
		String isDeleted;
		
		List<SalesPipeLine> salesArrayList=new ArrayList<SalesPipeLine>();
		SalesPipeLine salesPipeLine = null;
		ResultSet res;
		try{		        	
			
			PreparedStatement prepare=con.prepareStatement("select sp_id,customer_name, estimated_floor_builtup,actual_floor_builtup, estimated_floor_carpet, actual_floor_carpet, status_id,estimated_start_date, warehouse_id,isActive,isDeleted from salespipeline_master where isActive='Yes' and isDeleted='No' ");
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
				Date date = new Date();
				
				long diff = Math.abs(estimatedStartDate.getTime() - date.getTime());
				long age = diff / (24 * 60 * 60 * 1000);
				
				salesPipeLine = new SalesPipeLine();
				salesPipeLine.setSalesPipeLineId(salesPipeLineId);
			    salesPipeLine.setCustomerName(customerName);
			    salesPipeLine.setEstimatedFloorBuiltupArea(estimatedFloorBuiltupArea);
			    salesPipeLine.setActualFloorBuiltupArea(actualFloorBuiltupArea);
			    salesPipeLine.setEstimatedFloorCarpetArea(estimatedFloorCarpetArea);
			    salesPipeLine.setActualFloorCarpetArea(actualFloorCarpetArea);
			    salesPipeLine.setStatusWork(statusWork);
			    salesPipeLine.setEstimatedStartDate(estimatedStartDate);
			    salesPipeLine.setSalesPipeLineId(salesPipeLineId);
			    salesPipeLine.setAllocatedWarehouse(allocatedWarehouse);
			    salesPipeLine.setAge(age);
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


public List<SalesPipeLine> clientReportController() {

	

	Integer salesPipeLineId;
	String customerName;
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
	
	List<SalesPipeLine> salesArrayList=new ArrayList<SalesPipeLine>();
	SalesPipeLine salesPipeLine = null;
	ResultSet res;
	try{		        	
		
		PreparedStatement prepare=con.prepareStatement("select sp_id,customer_name, estimated_floor_builtup,actual_floor_builtup, estimated_floor_carpet, actual_floor_carpet, status_id,estimated_start_date, warehouse_id,isActive,isDeleted,expectedRevenue,actualRevenue from salespipeline_master where isActive='Yes' and isDeleted='No'");
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
			Date date = new Date();
			
			long diff = Math.abs(estimatedStartDate.getTime() - date.getTime());
			long age = diff / (24 * 60 * 60 * 1000);
			
			salesPipeLine = new SalesPipeLine();
			salesPipeLine.setSalesPipeLineId(salesPipeLineId);
		    salesPipeLine.setCustomerName(customerName);
		    salesPipeLine.setEstimatedFloorBuiltupArea(estimatedFloorBuiltupArea);
		    salesPipeLine.setActualFloorBuiltupArea(actualFloorBuiltupArea);
		    salesPipeLine.setEstimatedFloorCarpetArea(estimatedFloorCarpetArea);
		    salesPipeLine.setActualFloorCarpetArea(actualFloorCarpetArea);
		    salesPipeLine.setStatusWork(statusWork);
		    salesPipeLine.setEstimatedStartDate(estimatedStartDate);
		    salesPipeLine.setSalesPipeLineId(salesPipeLineId);
		    salesPipeLine.setAllocatedWarehouse(allocatedWarehouse);
		    salesPipeLine.setAge(age);
		    salesPipeLine.setIsActive(isActive);
		    salesPipeLine.setIsDeleted(isDeleted);
		    salesPipeLine.setExpectedRevenue(expectedRevenue);
		    salesPipeLine.setActualRevenue(actualRevenue);
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
	
	
		
		}
