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
	
	

public String addWarehouse(String warehouseName, Integer floorBuiltupArea, Integer floorCarpetArea,Integer rackBuiltupArea, Integer palette_positions, Integer totalNumberOfDocks) {
	
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
    warehouse.setPalette_positions(palette_positions);
    warehouse.setAvailable_floor_carpet_area(floorBuiltupArea);
    warehouse.setAvailable_rack_carpet_area(rackBuiltupArea);
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
		 String palette_positions;
		 String total_docks;	
		
		 HashMap<String, String> outputList= new HashMap<String, String>();
				try{
					
					/*Class.forName("com.mysql.jdbc.Driver");
					con=DriverManager.getConnection(url, userId, pwd);*/
					prepare=con.prepareStatement("select warehouse_name,floor_builtup_area,floor_carpet_area,rack_builtup_area,rack_builtup_area,palette_positions,total_docks from warehouse_master where warehouse_id=?");
		            prepare.setInt(1, warehouseId);

					res=prepare.executeQuery();
					
				      while(res.next()){
				          //Retrieve by column name
				    	  warehouse_id = String.valueOf(warehouseId);
				    	  warehouse_name = res.getString("warehouse_name");
				    	  floor_builtup_area = String.valueOf(res.getInt("floor_builtup_area"));
						  floor_carpet_area = String.valueOf(res.getInt("floor_carpet_area"));
						  rack_builtup_area = String.valueOf(res.getInt("rack_builtup_area"));
						  palette_positions = String.valueOf(res.getInt("palette_positions"));
						  total_docks = String.valueOf(res.getInt("total_docks"));
						 
						  
						  outputList.put("warehouse_id", warehouse_id);
				    	  outputList.put("warehouse_name", warehouse_name);
				    	  outputList.put("floor_builtup_area", floor_builtup_area);
				    	  outputList.put("floor_carpet_area",floor_carpet_area);
				    	  outputList.put("rack_builtup_area",rack_builtup_area);
				    	  outputList.put("palette_positions",palette_positions);
				    	  outputList.put("total_docks",total_docks);
				    	 
				       }
                      
				      
                  
				}
		       catch(Exception e)
		    {
		    	   System.out.println(e);
		    	    
		    }
				
				
				return outputList;
		
		
		
	}

	public String updateWarehouse(Integer warehouseId,String warehouseName, Integer floorBuiltupArea, Integer floorCarpetArea, Integer rackBuiltupArea, Integer palette_positions, Integer totalNumberOfDocks,Integer availableWarehouseFloor, Integer availableWarehouseRack) {
		
		
		Session session = HibernateUtil.getSesssion();
	    Transaction transaction = null;
	      try{
	         transaction = session.beginTransaction();
	         WarehouseEntity warehouse = (WarehouseEntity) session.get(WarehouseEntity.class, warehouseId);  
	         
	         warehouse.setWarehouse_name(warehouseName);
	         warehouse.setFloor_builtup_area(floorBuiltupArea);
	         warehouse.setFloor_carpet_area(floorCarpetArea);
	         warehouse.setRack_builtup_area(rackBuiltupArea);
	         warehouse.setPalette_positions(palette_positions);
	         warehouse.setTotal_docks(totalNumberOfDocks);
	       
	         Integer available_floor_carpet_area = warehouse.getAvailable_floor_carpet_area();
	         Integer available_rack_area = warehouse.getAvailable_rack_carpet_area();
	         
	         Integer newFloorAvailable = available_floor_carpet_area + availableWarehouseFloor ;
	         Integer newRackAvailable = available_rack_area + availableWarehouseRack;
	         
	         warehouse.setAvailable_floor_carpet_area(newFloorAvailable);
	         warehouse.setAvailable_rack_carpet_area(newRackAvailable);
	         
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
	    String totalSpaceAvailableCount = getTotalSpaceSum();

          dashboardIconInfoList.put("totalWarehouse", totalWarehouse);
          dashboardIconInfoList.put("totalClientsCount", totalClientsCount);
          dashboardIconInfoList.put("totalSpaceUtilizedCount", totalSpaceUtilizedCount);
          dashboardIconInfoList.put("totalSpaceAvailableCount", totalSpaceAvailableCount);
  		
			
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
	        
       criteriaSum.setProjection(Projections.sum("actualFloorBuiltupArea"));
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
	
	public static String getTotalSpaceSum()
	{
		String totalSpaceAvailableCount = null;
		
		
		Session session = HibernateUtil.getSesssion();
		   Transaction transaction = null;
		 
	      try{
		         transaction = session.beginTransaction();
  
       Criteria criteriaSum = session.createCriteria(WarehouseEntity.class, "warehouse");
	     criteriaSum.add(Restrictions.eq("warehouse.isActive", "Yes"));
	     criteriaSum.add(Restrictions.eq("warehouse.isDeleted", "No"));  
	        
       criteriaSum.setProjection(Projections.sum("available_floor_carpet_area"));
       List sumSPL = criteriaSum.list();

       totalSpaceAvailableCount = String.valueOf(sumSPL.get(0));

       session.getTransaction().commit();
       
		} 
				catch (Exception e) {
					if (transaction!=null) transaction.rollback();
			         e.printStackTrace(); 
			         }
		
		return totalSpaceAvailableCount;
		
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
	
	
	public List<Warehouse> listWarehouseData() {

		String totalSpaceAvailableCount = null;
		List<Warehouse> warehouseArrayList=new ArrayList<Warehouse>();
		Warehouse warehouse = null;
		
		
		Session session = HibernateUtil.getSesssion();
		   Transaction transaction = null;
		 
	      try{
		         transaction = session.beginTransaction();
  
       Criteria criteriaSum = session.createCriteria(WarehouseEntity.class, "warehouse");
	     criteriaSum.add(Restrictions.eq("warehouse.isActive", "Yes"));
	     criteriaSum.add(Restrictions.eq("warehouse.isDeleted", "No"));  
	        
       criteriaSum.setProjection(Projections.sum("available_floor_carpet_area"));
       List sumSPL = criteriaSum.list();

       totalSpaceAvailableCount = String.valueOf(sumSPL.get(0));
		warehouse = new Warehouse();
		warehouse.setName("");
		warehouse.setY(Integer.parseInt(totalSpaceAvailableCount));
		warehouseArrayList.add(warehouse);

       session.getTransaction().commit();
       
		} 
				catch (Exception e) {
					if (transaction!=null) transaction.rollback();
			         e.printStackTrace(); 
			         }
		
	
return warehouseArrayList;


}

	
	
	
		
	public List<Warehouse> listWarehouseByActive() {
		
				 String warehouse_name;
		 Integer floor_builtup_area;
		 
		List<Warehouse> warehouseArrayList=new ArrayList<Warehouse>();
		Warehouse warehouse = null;
		
		try{		        	
		
			PreparedStatement prepare=con.prepareStatement("select warehouse_id,warehouse_name,floor_builtup_area from warehouse_master where isActive='Yes' and isDeleted='No' ");
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
		
		
		 String customer_name;
		 Integer actual_floor_carpet;
		 
		List<Warehouse> warehouseArrayList=new ArrayList<Warehouse>();
		Warehouse warehouse = null;
	
		try{		        	
			
			WarehouseDaoImpl warehouseDao = new WarehouseDaoImpl();
			
			Integer warehouse_id = warehouseDao.getWarehouseId(warehouseName);
			
			
			prepare=con.prepareStatement("select customer_name,actual_floor_carpet from salespipeline_master where warehouse_id=? and isDeleted='No' and isActive='Yes'");
			prepare.setInt(1,warehouse_id);
			res=prepare.executeQuery();
			
			
			
			while(res.next())
			{
				customer_name = res.getString("customer_name");
				actual_floor_carpet = (int) res.getDouble("actual_floor_carpet");
				
		/*		availableFloorBuiltupArea = (int) (available_floor_carpet_area*1.25);
				occupiedSpace = (floor_builtup_area-availableFloorBuiltupArea); */
				warehouse = new Warehouse();
				
				warehouse.setName(customer_name);
				warehouse.setY(actual_floor_carpet);
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
			
			
			PreparedStatement prepare=con.prepareStatement("select warehouse_name from warehouse_master where warehouse_id=? ");
			prepare.setInt(1,warehouseId);
			ResultSet res=prepare.executeQuery();
			
			while(res.next())
			{
				warehouseName = res.getString("warehouse_name");; 
				
			}
          
			prepare.close();
			res.close();
           
		} 
				catch (Exception e) {
	      e.printStackTrace();
	    }
		
	 return warehouseName;
	}
	
	public Integer getWarehouseId(String warehouseName) {
		
		Integer warehouseId=null;
	 
	
	 Session session = HibernateUtil.getSesssion();
		Transaction transaction = null;
		List<WarehouseEntity> warehouseList = null;
	      try{
	         transaction = session.beginTransaction();
		 Criteria criteria = session.createCriteria(WarehouseEntity.class, "warehouse");
		 criteria.add(Restrictions.eq("warehouse.warehouse_name", warehouseName));
	        
	       warehouseList = new ArrayList<WarehouseEntity>();
	        warehouseList = (List<WarehouseEntity>) criteria.list();
	        
	        for (int k = 0; k < warehouseList.size(); k++) {  
				
	        	warehouseId=warehouseList.get(k).getWarehouse_id();
				 
	        }
			
	        
	        
	        session.getTransaction().commit();
	    
	      }
			 catch (HibernateException e) {
				 if (transaction!=null) 
				    	transaction.rollback();
				    e.printStackTrace(); 
				 }
			  return warehouseId;
	 
	}



	public List<Warehouse> listWarehouseSummary() {
		
		
		Session session = HibernateUtil.getSesssion();
		Transaction transaction = null; 
		List<WarehouseEntity> warehouseList =null;
		Warehouse warehouse;
		List<Warehouse> warehouseCustomList = null;
		 Integer totalSellableArea;
		 Integer totalUtilizedSpace;
		 Integer floorBuiltUp;
		 Integer rackBuiltUp;
		 Integer avialableSpace;
		 Integer avialableSpace1;
		 Integer avialableSpace2;
		 Integer warehouseId;
		 String perWarehouseRevenue;
		 
		 try
		 {
			 transaction= session.beginTransaction();
		 Criteria criteria = session.createCriteria(WarehouseEntity.class, "warehouse");
		 criteria.add(Restrictions.eq("warehouse.isActive", "Yes"));
	        criteria.add(Restrictions.eq("warehouse.isDeleted", "No"));    
 
 	        warehouseCustomList = new ArrayList<Warehouse>();
   	        warehouseList = new ArrayList<WarehouseEntity>();
	        warehouseList = (List<WarehouseEntity>) criteria.list();
	        
            for (int k = 0; k < warehouseList.size(); k++) {  
				
            	avialableSpace1 = warehouseList.get(k).getAvailable_floor_carpet_area();
            	avialableSpace2 = warehouseList.get(k).getAvailable_rack_carpet_area();
            	avialableSpace = avialableSpace1 + avialableSpace2;
            	floorBuiltUp = warehouseList.get(k).getFloor_builtup_area();
            	rackBuiltUp = warehouseList.get(k).getRack_builtup_area();
            	totalSellableArea = floorBuiltUp + rackBuiltUp;
            	totalUtilizedSpace = totalSellableArea - avialableSpace;
            	warehouseId = warehouseList.get(k).getWarehouse_id();
            	
            	Criteria criteriaSum = session.createCriteria(SalesPipeLineEntity.class, "salesPipeLine");
       	     criteriaSum.add(Restrictions.eq("salesPipeLine.allocatedWarehouse", warehouseId)); 
       	     criteria.add(Restrictions.eq("salesPipeLine.statusWork", "billable")); 
       	        
              criteriaSum.setProjection(Projections.sum("actualRevenue"));
              List sumSPL = criteriaSum.list();

              perWarehouseRevenue = String.valueOf(sumSPL.get(0));
            	
            	
            	warehouse = new Warehouse();
				warehouse.setName(warehouseList.get(k).getWarehouse_name());
				warehouse.setTotalSellableArea(totalSellableArea);
				warehouse.setTotalUtilizedSpace(totalUtilizedSpace);
				warehouse.setAvialableSpace(avialableSpace);
				warehouse.setPerWarehouseRevenue(perWarehouseRevenue);
				warehouseCustomList.add(warehouse);
				 
	        }
	        
	        session.getTransaction().commit();
		 }
		 catch (HibernateException e) {
			 if (transaction!=null) 
			    	transaction.rollback();
			    e.printStackTrace(); 
			 }
			 
		 return warehouseCustomList;
		
		
	}
	
	

}
