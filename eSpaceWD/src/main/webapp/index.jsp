<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to eSpace | Home Page</title>

<spring:url value="/resources/css/theme-default.css" var="themeCss" />
<spring:url value="/resources/js/plugins/jquery/jquery.min.js" var="jqueryJs" />

<link href="${themeCss}" rel="stylesheet" />
<script src="${jqueryJs}"></script>

		
 <script type='text/javascript'>
$(document).ready(function(){


	$('#registerLink').css( 'cursor', 'pointer' );
	$('#dashboardLink').css( 'cursor', 'pointer' );
	
	
	$("#registerLink").click(function(){
		 $("#registerDiv").fadeIn();
		 
		 $('#loginDiv').hide();
		 
		});

	$("#loginLink").click(function(){
		 $("#loginDiv").fadeIn();
		 
		 $('#registerDiv').hide();
		 
		 
		});
		
		
		
	$("#addWarehouse").click(function(){
		 $("#addWarehouseDiv").fadeIn();
		 
		 
		 
		});
		
	
});
</script>

</head>

    <body>
  <div class="login-container lightmode">
        
            <div class="login-box animated fadeInDown"  style="margin-top: 20px;">
               
                <div class="login-body" id="loginDiv" style="margin-top: 90px;display:show;" >
                    <div class="login-title"><strong>Log In</strong> to your account</div>
                    <form action="login" class="form-horizontal" method="post">
                    <div class="form-group">
                        <div class="col-md-12">
                            <input type="text" class="form-control" placeholder="E-mail" name="emailId"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <input type="password" class="form-control" placeholder="Password" name="password"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-6">
                            <a href="#" class="btn btn-link btn-block">Forgot your password?</a>
                        </div>
                        <div class="col-md-6">
                            <input type="submit" value="Log In" class="btn btn-info btn-block" />
                        </div>
                    </div>
                   
                    <div class="login-subtitle">
                        Don't have an account yet? <a id="registerLink" href="#">Create an account</a>
                    </div>
                    </form>
                </div>
                
                     <div class="login-body" id="registerDiv" style="margin-top: -10px;display:none" >
                       <div class="login-title" >
                        <h3 class="panel-title" style="font-size: x-large;color:white;padding:5px;">Sign-Up</h3>                                
                       </div>
                  
                               
                            <div class="panel-body" style="background: rgba(255, 255, 255, 0.2);padding: 20px 40px;">
                                   <form action="signup" method="post" role="form" class="form-horizontal">
                             
                                    
                                    <div class="form-group">
                                        <label>Full-Name</label>
                                        <input type="text" class="form-control" name="firstName" placeholder="Hii,whats your name ?">
                                    </div>
                                    <div class="form-group">
                                        <label>Designation</label>
                                        <input type="text" class="form-control" name="designation" placeholder="Designation ?  eg: Developer,Senior Manager ">
                                    </div> 
									<div class="form-group">
                                        <label>Username</label>
                                        <input type="text" class="form-control" name="emailId" placeholder="Enter E-mail">
                                    </div>
                                    <div class="form-group">
                                        <label>Password</label>
                                        <input type="password" class="form-control" name="password" placeholder="Enter Password">
                                    </div> 
                                
                                   									
                                    <div class="form-group">
                                        <div class="col-md-8">
                                         <div class="login-subtitle">
                        Already have an account yet? <a id="loginLink" href="#">Log-In</a>
                    </div>
                                        </div>
                                        <div class="col-md-4">
                                            <button class="btn btn-info btn-block">Register</button>
                                        </div>
                                    </div>
								</form>
									
                                </div>     
                </div>
                
                
                
                <div class="login-footer" style="margin-bottom: 210px;">
                    <div class="pull-left">
                        &copy; 2016 eSpace
                    </div>
                   
                </div>
            </div>
            
        </div>


</head>
<body>





</body>
</html>