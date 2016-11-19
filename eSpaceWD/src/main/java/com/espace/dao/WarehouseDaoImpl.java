package com.espace.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.espace.entity.SalesPipeLineEntity;
import com.espace.entity.WarehouseEntity;
import com.espace.model.Dashboard;
import com.espace.model.Warehouse;
import com.espace.persistance.HibernateUtil;
import com.mysql.jdbc.Statement;

@Transactional
@Repository("warehouseDao")
public class WarehouseDaoImpl implements WarehouseDao {

	
	
	Connection con;
	PreparedStatement prepare;			
	ResultSet res;
	
	public WarehouseDaoImpl() throws ClassNotFoundException, SQLException
	{
	String url="jdbc:mysql://citiswd-mysql-iqbal.crr7bged4sau.ap-south-1.rds.amazonaws.com:3306/citi_espace";
	String userId="Iqbal";
	String pwd="Iqubal5192#me";
	Class.forName("com.mysql.jdbc.Driver");
	con=DriverManager.getConnection(url, userId, pwd);
	}
	
	

public String addWarehouse(String warehouseName, Integer floorBuiltupArea, Integer floorCarpetArea,Integer rackBuiltupArea, Integer rackCarpetArea, Integer totalNumberOfDocks) {
	
String isActive="Yes";
String isDeleted="No";		

 Session session = HibernateUtil.getSesssion();
 
 Transaction transaction = null;
 try{
	 
	 transaction= session.beginTransaction();
    WarehouseEntity warehouse = new WarehouseEntity();
    warehouse.setWarehouse_name(warehouseName);
    warehouse.setFloor_builtup_area(floorBuiltupArea);
    warehouse.setFloor_carpet_area(floorCarpetArea);
    warehouse.setRack_builtup_area(rackBuiltupArea);
    warehouse.setRack_carpet_area(rackCarpetArea);
    warehouse.setAvailable_floor_carpet_area(floorCarpetArea);
    warehouse.setAvailable_rack_carpet_area(rackCarpetArea);
    warehouse.setIsActive(isActive);
    warehouse.setIsDeleted(isDeleted);
    warehouse.setTotal_docks(totalNumberOfDocks);

    
    session.save(warehouse); 
    session.getTransaction().commit();
	
    return "successful";
 }
 catch (HibernateException e) {
    if (transaction!=null) 
    	transaction.rollback();
    e.printStackTrace(); 
 }
 
 return "failed";
	
}


	public List<Warehouse> listWarehouse() {
		
		Session session = HibernateUtil.getSesssion();
		Transaction transaction = null; 
		List<Warehouse> warehouseList =null;
		 try
		 {
			 transaction= session.beginTransaction();
		 Criteria criteria = session.createCriteria(WarehouseEntity.class, "warehouse");
		 criteria.add(Restrictions.eq("warehouse.isActive", "Yes"));
	        criteria.add(Restrictions.eq("warehouse.isDeleted", "No"));    
		 
	       warehouseList = new ArrayList<Warehouse>();
	        warehouseList = (List<Warehouse>) criteria.list();
	        
	        session.getTransaction().commit();
		 }
		 catch (HibernateException e) {
			 if (transaction!=null) 
			    	transaction.rollback();
			    e.printStackTrace(); 
			 }
			 
		 return warehouseList;
		
		
	}
	
	
	
	public HashMap<String, String> getWarehousrDetailsByWHId(Integer warehouseId) {
	
		
		 String warehouse_id;
		 String warehouse_name;
		 String floor_builtup_area;
		 String floor_carpet_area;
		 String rack_builtup_area; 
		 String rack_carpet_area;
		 String total_docks;	
		
		 HashMap<String, String> outputList= new HashMap<String, String>();
				try{
					
					/*Class.forName("com.mysql.jdbc.Driver");
					con=DriverManager.getConnection(url, userId, pwd);*/
					prepare=con.prepareStatement("select warehouse_name,floor_builtup_area,floor_carpet_area,rack_builtup_area,rack_builtup_area,rack_carpet_area,total_docks from warehouse_master where warehouse_id=?");
		            prepare.setInt(1, warehouseId);

					res=prepare.executeQuery();
					
				      while(res.next()){
				          //Retrieve by column name
				    	  warehouse_id = String.valueOf(warehouseId);
				    	  warehouse_name = res.getString("warehouse_name");
				    	  floor_builtup_area = String.valueOf(res.getInt("floor_builtup_area"));
						  floor_carpet_area = String.valueOf(res.getInt("floor_carpet_area"));
						  rack_builtup_area = String.valueOf(res.getInt("rack_builtup_area"));
						  rack_carpet_area = String.valueOf(res.getInt("rack_carpet_area"));
						  total_docks = String.valueOf(res.getInt("total_docks"));
						 
						  
						  outputList.put("warehouse_id", warehouse_id);
				    	  outputList.put("warehouse_name", warehouse_name);
				    	  outputList.put("floor_builtup_area", floor_builtup_area);
				    	  outputList.put("floor_carpet_area",floor_carpet_area);
				    	  outputList.put("rack_builtup_area",rack_builtup_area);
				    	  outputList.put("rack_carpet_area",rack_carpet_area);
				    	  outputList.put("total_docks",total_docks);
				    	 
				       }
                      
				      
                  
				}
		       catch(Exception e)
		    {
		    	   System.out.println(e);
		    	    
		    }
				
				
				return outputList;
		
		
		
	}

	public String updateWarehouse(Integer warehouseId,String warehouseName, Integer floorBuiltupArea, Integer floorCarpetArea, Integer rackBuiltupArea, Integer rackCarpetArea, Integer totalNumberOfDocks) {
		
		
		Session session = HibernateUtil.getSesssion();
	    Transaction transaction = null;
	      try{
	         transaction = session.beginTransaction();
	         WarehouseEntity warehouse = (WarehouseEntity) session.get(WarehouseEntity.class, warehouseId);  
	         
	         warehouse.setWarehouse_name(warehouseName);
	         warehouse.setFloor_builtup_area(floorBuiltupArea);
	         warehouse.setFloor_carpet_area(floorCarpetArea);
	         warehouse.setRack_builtup_area(rackBuiltupArea);
	         warehouse.setRack_carpet_area(rackCarpetArea);
	         warehouse.setTotal_docks(totalNumberOfDocks);
	        
			 session.update(warehouse); 
	         transaction.commit();
	         return "successful"; 
	      }catch (HibernateException e) {
	         if (transaction!=null) transaction.rollback();
	         e.printStackTrace(); 
	      }
	      return "failed";
		

	}

	public List<Warehouse> getWarehouseAreaById(Integer warehouseId) {
		
		Session session = HibernateUtil.getSesssion();
		Transaction transaction = null;
		List<Warehouse> warehouseList = null;
	      try{
	         transaction = session.beginTransaction();
		 Criteria criteria = session.createCriteria(WarehouseEntity.class, "warehouse");
		 criteria.add(Restrictions.eq("warehouse.warehouse_id", warehouseId));
	        
	       warehouseList = new ArrayList<Warehouse>();
	        warehouseList = (List<Warehouse>) criteria.list();
	        
	        session.getTransaction().commit();
	    
	      }
			 catch (HibernateException e) {
				 if (transaction!=null) 
				    	transaction.rollback();
				    e.printStackTrace(); 
				 }
			  return warehouseList;
		
		

		
	}

	public List<Warehouse> listWarehouseById(Integer warehouseId) {
		
		
		Session session = HibernateUtil.getSesssion();
		Transaction transaction = null;
		List<Warehouse> warehouseList = null;
	      try{
	    	  transaction = session.beginTransaction();
		 Criteria criteria = session.createCriteria(WarehouseEntity.class, "warehouse");
		 criteria.add(Restrictions.eq("warehouse.warehouse_id", warehouseId));
	        
            warehouseList = new ArrayList<Warehouse>();
	        warehouseList = (List<Warehouse>) criteria.list();
	        
	        session.getTransaction().commit();
		    
	      }
			 catch (HibernateException e) {
				 if (transaction!=null) 
				    	transaction.rollback();
				    e.printStackTrace(); 
				 }

	        
	        return warehouseList;
		

	}

	public String updateSpaceAvialabilityWarehouse(Integer warehouseId,Integer avialableFloor, Integer availableRack) {
	
		Session session = HibernateUtil.getSesssion();
		   Transaction transaction = null;
	      try{
	         transaction = session.beginTransaction();
	         WarehouseEntity warehouse = (WarehouseEntity) session.get(WarehouseEntity.class, warehouseId);  
	         
	         warehouse.setAvailable_floor_carpet_area(avialableFloor);
	         warehouse.setAvailable_rack_carpet_area(availableRack);
	      
	        
			 session.update(warehouse); 
	         transaction.commit();
	         return "successful"; 
	      }catch (HibernateException e) {
	         if (transaction!=null) transaction.rollback();
	         e.printStackTrace(); 
	      }
		
	      return "failed";
		}
	
	
	public HashMap<String, String> getDashboardIconInfo() {
	
			
		HashMap<String, String> dashboardIconInfoList=new HashMap<String, String>();
		Dashboard dash = null;
		
		String totalWarehouse = getTotalWarehouseAre();
		String totalClientsCount = getClientCount(); 
	    String totalSpaceUtilizedCount = getSumCount();  

          dashboardIconInfoList.put("totalWarehouse", totalWarehouse);
          dashboardIconInfoList.put("totalClientsCount", totalClientsCount);
          dashboardIconInfoList.put("totalSpaceUtilizedCount", totalSpaceUtilizedCount);
		
			
		return dashboardIconInfoList;
		
		
		
		
		
	}
	
	public static String getTotalWarehouseAre()
	{
		String totalWarehouse = null;
		
		Session session = HibernateUtil.getSesssion();
		   Transaction transaction = null;
	      try{
	         transaction = session.beginTransaction();
		   
      Criteria criteria = session.createCriteria(WarehouseEntity.class, "warehouse");
      criteria.add(Restrictions.eq("warehouse.isActive", "Yes"));
	        criteria.add(Restrictions.eq("warehouse.isDeleted", "No"));  
	        
      criteria.setProjection(Projections.rowCount());
      List rowCount = criteria.list();

      totalWarehouse = String.valueOf(rowCount.get(0));
	     
      session.getTransaction().commit();
	      }
	      catch (Exception e) {
				if (transaction!=null) transaction.rollback();
		         e.printStackTrace(); 
		         }
	      return totalWarehouse;
		
		
	}
	
	
	public static String getClientCount()
	{
		
		String totalClientsCount = null;
		
		Session session = HibernateUtil.getSesssion();
		   Transaction transaction = null;
		
		      try{
			         transaction = session.beginTransaction();
				 
		      
	         Criteria criteria2 = session.createCriteria(SalesPipeLineEntity.class, "salesPipeLine");
	         criteria2.add(Restrictions.eq("salesPipeLine.statusWork", "confirmed"));
		     criteria2.add(Restrictions.eq("salesPipeLine.isActive", "Yes"));
		     criteria2.add(Restrictions.eq("salesPipeLine.isDeleted", "No"));  
		        
	         criteria2.setProjection(Projections.rowCount());
	         List rowCountSPL = criteria2.list();

	         totalClientsCount = String.valueOf(rowCountSPL.get(0));
	        
	         session.getTransaction().commit();
	         
		  }
	    catch (Exception e) {
				if (transaction!=null) transaction.rollback();
		         e.printStackTrace(); 
		         }
		   return totalClientsCount;
	}
	
	public static String getSumCount()
	{
		String totalSpaceUtilizedCount = null;
		
		
		Session session = HibernateUtil.getSesssion();
		   Transaction transaction = null;
		 
	      try{
		         transaction = session.beginTransaction();
  
       Criteria criteriaSum = session.createCriteria(SalesPipeLineEntity.class, "salesPipeLine");
	     criteriaSum.add(Restrictions.eq("salesPipeLine.isActive", "Yes"));
	     criteriaSum.add(Restrictions.eq("salesPipeLine.isDeleted", "No"));  
	        
       criteriaSum.setProjection(Projections.sum("actualFloorCarpetArea"));
       List sumSPL = criteriaSum.list();

       totalSpaceUtilizedCount = String.valueOf(sumSPL.get(0));

       session.getTransaction().commit();
       
		} 
				catch (Exception e) {
					if (transaction!=null) transaction.rollback();
			         e.printStackTrace(); 
			         }
		
		return totalSpaceUtilizedCount;
		
	}

	public String deleteWarehouse(Integer warehouseId) {

		String isActive="No";
		String isDeleted="Yes";	

		Session session = HibernateUtil.getSesssion();
		   Transaction transaction = null;
	      try{
	         transaction = session.beginTransaction();
	         WarehouseEntity warehouse = (WarehouseEntity) session.get(WarehouseEntity.class, warehouseId);  
	         
	         warehouse.setIsActive(isActive);
	         warehouse.setIsDeleted(isDeleted);
	      
	        
			 session.update(warehouse); 
	         transaction.commit();
	         return "successful"; 
	      }catch (HibernateException e) {
	         if (transaction!=null) transaction.rollback();
	         
	         e.printStackTrace(); 
	      }
		
	      return "failed";
		}
		
		
	public List<Warehouse> listWarehouseByActive() {
		
				 String warehouse_name;
		 Integer floor_builtup_area;
		 
		List<Warehouse> warehouseArrayList=new ArrayList<Warehouse>();
		Warehouse warehouse = null;
		
		try{		        	
		
			PreparedStatement prepare=con.prepareStatement("select warehouse_id,warehouse_name,floor_builtup_area,floor_carpet_area,rack_builtup_area,rack_builtup_area,rack_carpet_area,total_docks from warehouse_master where isActive='Yes' and isDeleted='No' ");
           res=prepare.executeQuery();
			
			
			
			while(res.next())
			{
				
				warehouse_name = res.getString("warehouse_name");
				floor_builtup_area = res.getInt("floor_builtup_area");
				
				
				warehouse = new Warehouse();
				warehouse.setName(warehouse_name);
				warehouse.setY(floor_builtup_area);
				warehouse.setDrilldown(true);
				warehouseArrayList.add(warehouse);
				
				
				
			}
           
         
		} 
				catch (Exception e) {
	      e.printStackTrace();
	    }
		
			
		return warehouseArrayList;
		
		
	}

	public List<Warehouse> listWarehouseDrillDown(String warehouseName) {
		
		

		String name="Available Space";
		 
		 Integer available_floor_carpet_area,availableFloorBuiltupArea,occupiedSpace;
		 Integer floor_builtup_area;
		
		List<Warehouse> warehouseArrayList=new ArrayList<Warehouse>();
		Warehouse warehouse = null;
	
		try{		        	
			
			
			prepare=con.prepareStatement("select floor_builtup_area,available_floor_carpet_area from warehouse_master where warehouse_name=? ");
			prepare.setString(1,warehouseName);
			res=prepare.executeQuery();
			
			
			
			while(res.next())
			{
				floor_builtup_area = res.getInt("floor_builtup_area");
				available_floor_carpet_area = res.getInt("available_floor_carpet_area");
				
				availableFloorBuiltupArea = (int) (available_floor_carpet_area*1.25);
				occupiedSpace = (floor_builtup_area-availableFloorBuiltupArea); 
				warehouse = new Warehouse();
				
				warehouse.setX(occupiedSpace);
				warehouse.setY(availableFloorBuiltupArea);
				warehouseArrayList.add(warehouse);
				
				
			}
          
           
		} 
				catch (Exception e) {
	      e.printStackTrace();
	    }
	
			
		return warehouseArrayList;
		
		
	}




	public String getWarehouseName(Integer warehouseId) {
	
		String warehouseName=null;
		
try{		        	
			
			
			prepare=con.prepareStatement("select warehouse_name from warehouse_master where warehouse_id=? ");
			prepare.setInt(1,warehouseId);
			res=prepare.executeQuery();
			
			while(res.next())
			{
				warehouseName = res.getString("warehouse_name");; 
				
			}
          
           
		} 
				catch (Exception e) {
	      e.printStackTrace();
	    }
		
	 return warehouseName;
	}
	
	
	

}
