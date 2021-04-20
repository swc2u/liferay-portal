package cscl.appointment.booking.web.portlet.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.Validator;

import java.io.IOException;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import cscl.appointment.admin.table.model.csclAppointmentAdmin;
import cscl.appointment.admin.table.service.csclAppointmentAdminLocalServiceUtil;
import cscl.appointment.booking.web.constants.CsclAppointmentBookingWebPortletKeys;

@Component(
		property = {
				"javax.portlet.name=" + CsclAppointmentBookingWebPortletKeys.CSCLAPPOINTMENTBOOKINGWEB,
			"mvc.command.name=/appointment/dependentDropdown"
		},
		service = MVCResourceCommand.class
	)

public class DependentDropdownMVCAction implements MVCResourceCommand {

	@SuppressWarnings("deprecation")
	@Override
	 public boolean serveResource(ResourceRequest resourceRequest,ResourceResponse resourceResponse) throws PortletException
	{
		System.out.println("Inside serve Resource");
		  String op = resourceRequest.getParameter("operation");
          System.out.println("op......"+op);
          List<csclAppointmentAdmin> CsclAppointeeAdmin =csclAppointmentAdminLocalServiceUtil.findAll();
       //   List<AdminModule> CsclAppointeeAdmin=AdminModuleLocalServiceUtil.findAll();
          System.out.println("CsclAppointeeAdmin:-"+CsclAppointeeAdmin);
 
          if (op.equals("SelectedDate")) {
              String id = resourceRequest.getParameter("id");
         
             long AppointeeID=Long.parseLong(id);
              System.out.println("****AppointeeID for date dropdown****:-"+AppointeeID);
              List<csclAppointmentAdmin> CsclAppointee =csclAppointmentAdminLocalServiceUtil.getByID(AppointeeID);
              System.out.println("CsclAppointee:-"+CsclAppointee);
           
              
			
			  String Appointee=""; 
			  for (csclAppointmentAdmin temp : CsclAppointee) 
			  {
			  System.out.println("inside loop");
			  Appointee = temp.getAppointee();
			  } 
			  System.out.println("-----Name of Appointee------:-"+Appointee);
			  
			  List<csclAppointmentAdmin> CsclAppointee1 = csclAppointmentAdminLocalServiceUtil.getByappointee(Appointee);
		   
         //ArrayList<String> arrlist = new ArrayList<String>(); 
		 String listString="";
       int count=0;
       String temp1="";
       String temp2="";
       String temp3="";
		 for (csclAppointmentAdmin temp : CsclAppointee1) 
		 {
			 listString = temp.getAppointedDate();
			 System.out.println("ListString inside for"+listString);
			 if(count==0)
			 {
				 temp1=listString;
			 }
			 if(count>0)
			 {
				 temp2=temp1+","+listString;
				 temp1=temp2;
			 }
			 count++;
			
			 System.out.println("count"+count);
			 
		 }
		 System.out.println("temp1"+temp1);
		 System.out.println("temp3"+temp3);
		 System.out.println("count"+count);
		 String DefaultSelected="Select Date";
		 if(count==1)
		 {
			 listString=DefaultSelected+","+temp1;
		 }
		 if(count>1)
		 {
			 listString=DefaultSelected+","+temp2;
		 }
		 
		 
              System.out.println("listString For Date Selection:-----"+listString);
              resourceResponse.setContentType("text/html");
              try {
				resourceResponse.getWriter().write(listString);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
          
          }

		if (op.equalsIgnoreCase("SelectedTime")) { 
			System.out.println("SelectedTime id:");
			 String id = resourceRequest.getParameter("id");
			 System.out.println("id as string"+id);
             //long ID=Long.parseLong(id);

             System.out.println("Selected Date for time ropdown-"+id);
			/*
			 * // List<AdminModule> CsclAppointee= AdminModuleLocalServiceUtil.getByID(ID);
			 * List<csclAppointmentAdmin> CsclAppointee
			 * =csclAppointmentAdminLocalServiceUtil.getByID(ID);
			 * System.out.println("CsclAppointee"+CsclAppointee);
			 * 
			 * String AvailabeDate=""; for (csclAppointmentAdmin temp : CsclAppointee) {
			 * System.out.println("inside loop"); AvailabeDate = temp.getAppointedDate();
			 * 
			 * }
			 */
          
             List<csclAppointmentAdmin> CsclAppointee1 =csclAppointmentAdminLocalServiceUtil.getByappointedDate(id);
             
		 String firstSlot="";
		 String SecondSlot="";
		 String ThirdSlot="";
		 String fourthSlot="";
		 String fifthSlot="";
		 String sixthSlot="";
		 String listString= "";
       for (csclAppointmentAdmin temp : CsclAppointee1) 
        {
        	 System.out.println("inside loop");
        	 
        	 firstSlot = temp.getFromTime();
        	 SecondSlot=temp.getSecondTimeSlot();
        	 ThirdSlot=temp.getThirdTimeSlot();
        	 fourthSlot=temp.getFourthTimeSlot();
        	 fifthSlot=temp.getFifthTimeSlot();
        	 sixthSlot=temp.getSixthTimeSlot();
       }
      
       
       if(Validator.isNotNull(firstSlot)&&Validator.isNull(SecondSlot)&&Validator.isNull(ThirdSlot)&&Validator.isNull(fourthSlot)&&Validator.isNull(fifthSlot)&&Validator.isNull(sixthSlot)) 
		 {
			 listString=firstSlot; 
			 System.out.println("one slot"+listString);
		 }
		 
		 if(Validator.isNotNull(firstSlot)&&Validator.isNotNull(SecondSlot)&&Validator.isNull(ThirdSlot)&&Validator.isNull(fourthSlot)&&Validator.isNull(fifthSlot)&&Validator.isNull(sixthSlot)) 
		 { 
			listString=firstSlot+","+SecondSlot;
			 System.out.println("Second slot"+listString);
		 }
		  
		 if(Validator.isNotNull(firstSlot)&&Validator.isNotNull(SecondSlot)&&Validator.isNotNull(ThirdSlot)&&Validator.isNull(fourthSlot)&&Validator.isNull(fifthSlot)&&Validator.isNull(sixthSlot)) 
		 {
		 listString=firstSlot+","+SecondSlot+","+ThirdSlot; 
		 System.out.println("third slot"+listString);
		 }
		 
		 if(Validator.isNotNull(firstSlot)&&Validator.isNotNull(SecondSlot)&&Validator.isNotNull(ThirdSlot)&&Validator.isNotNull(fourthSlot)&&Validator.isNull(fifthSlot)&&Validator.isNull(sixthSlot)) 
		 {
		 listString=firstSlot+","+SecondSlot+","+ThirdSlot+","+fourthSlot; 
		 System.out.println("fourth slot"+listString);
		 }
		 
       System.out.println("-----TimeList------"+listString);


           //  Gson json = new Gson();
             //String countryList1 = json.toJson(listString);
             System.out.println("listString"+listString);
             resourceResponse.setContentType("text/html");
             try {
				resourceResponse.getWriter().write(listString);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
         
		
		}
		return true;
		 
	}
	

}
