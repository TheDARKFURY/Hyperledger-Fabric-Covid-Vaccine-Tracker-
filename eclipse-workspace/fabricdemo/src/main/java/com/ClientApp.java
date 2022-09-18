package com;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeoutException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hyperledger.fabric.gateway.Contract;
import org.hyperledger.fabric.gateway.ContractException;
import org.hyperledger.fabric.gateway.Gateway;
import org.hyperledger.fabric.gateway.Network;
import org.hyperledger.fabric.gateway.Wallet;
import org.hyperledger.fabric.gateway.Wallets;

/**
 * Servlet implementation class ClientApp
 */
public final class ClientApp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static 
	{
	    System.setProperty("org.hyperledger.fabric.sdk.service_discovery.as_localhost", "true");
	}
	
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		  Path walletPath = Paths.get("wallet");
	        Wallet wallet = Wallets.newFileSystemWallet(walletPath);
	        // load a CCP
	        Path networkConfigPath = Paths.get("/home", "mohit","eclipse-workspace","fabric-samples", "test-network", "organizations", "peerOrganizations", "org1.example.com", "connection-org1.yaml");
	        
	        Gateway.Builder builder = Gateway.createBuilder();
	        builder.identity(wallet, "appUser").networkConfig(networkConfigPath).discovery(true);
	 
	        // create a gateway connection
	        try (Gateway gateway = builder.connect()) 
	        {
	        	
	 
	            // get the network and contract
	        	
	        	Network network = gateway.getNetwork("samplechannel");
	            Contract contract = network.getContract("CovidVT");
	            
	    		String name=request.getParameter("name");
	    		String age =request.getParameter("age");
	    		String id=request.getParameter("id");
	    		String key=request.getParameter("key");
	    		String gender=request.getParameter("gender");
	    		String vaccinename=request.getParameter("vaccinename");
	    		String dose=request.getParameter("dose");
	    		String date1=request.getParameter("date-of-vaccination");
	            
	            
	            
	            
	      
	            //, "1", "Mohit","21","male","123123123","Covaxin","30-08-2000",""
	            byte[] result;
	           
	            contract.submitTransaction("addPerson", key, name,age, gender ,id, vaccinename, date1,dose );
	            try {
					result = contract.evaluateTransaction("queryPerson", "5001");
					System.out.println(new String(result));
	            } catch (ContractException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            
	 
	 //           contract.submitTransaction("changePersonDose", "1", "3");
	   //         result = contract.evaluateTransaction("queryPerson", "1");
	     //       System.out.println(new String(result));

		
	        } catch (ContractException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (TimeoutException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		
		
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
