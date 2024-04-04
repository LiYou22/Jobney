package model.connection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.company.Company;
import model.enums.CONNECTSTATUS;

public class ConnectionList {
	private List<Connection> connections;
	
	public ConnectionList() {
		this.connections = new ArrayList<>();
	}
		
    public List<Connection> getConnectionList(){
    	return connections;
    }
    
    public void addConnection(Connection connection) {
    	connections.add(connection);
	}
    
    public Connection findConnection(String connectionID) {
    	for(Connection connection: connections) {
    		if(connection.getConnectionID().equals(connectionID)) {
    			return connection;
    		}
    	}
    	return null;
    }
    
    public void deleteConnection(String connectionID) {
    	Connection connectionToRemove = findConnection(connectionID);
    	if(connectionToRemove != null) {
    		connections.remove(connectionToRemove);
    	}
    }
    
    public int countTotalConnections() {
    	return connections.size();
    }
    
//    public int countAcceptance() {
//    	int count = 0;
//    	for(Connection connection: connections) {
//    		if(connection.isAccepted()) {    //connection status 
//    			count++;
//    		}
//    	}
//    	return count;
//    }
    
//    public double countAcceptRate() {
//    	if(connections.size() == 0) {
//    		return 0; // to avoid division by zero
//    	}
//    	return (double) countAcceptance()/ connections.size() * 100;
//    }
    
    public int countInformationInterview() {
    	int count = 0;
    	for(Connection connection: connections) {
    		if
    		(connection.getStatus() == CONNECTSTATUS.INFORMATIONINTERVIEW) {
    			count++;
    		}
    	}
    	return count;
    }
    
//    public String findCompanyWithMostConnections() {
//    	Map<String, Integer> companyConnectionCount = new HashMap<>();
//    	for (Connection connection : connections) {
//    		String company = connection.getCompany(); // how to get company name?
//    		companyConnectionCount.put(company, companyConnectionCount.getOrDefault(company, 0)+1);
//    	}
//    	int maxConnections = 0;
//    	String companyWithMostConnections = null;
//    	for(Map.Entry<String, Integer> entry: companyConnectionCount.entrySet()) {
//    		if(entry.getValue() > maxConnections) {
//    			maxConnections = entry.getValue();
//    			companyWithMostConnections = entry.getKey();
//    		}
//    	}
//    		return companyWithMostConnections;
//    }
    
//    public String findCompanyWithLeastConnections() {
//        Map<String, Integer> companyConnectionCount = new HashMap<>();
//        for (Connection connection : connections) {
//            String company = connection.getCompany();
//            companyConnectionCount.put(company, companyConnectionCount.getOrDefault(company, 0) + 1);
//        }
//        int minConnections = Integer.MAX_VALUE;
//        String companyWithLeastConnections = null;
//        for (Map.Entry<String, Integer> entry : companyConnectionCount.entrySet()) {
//            if (entry.getValue() < minConnections) {
//                minConnections = entry.getValue();
//                companyWithLeastConnections = entry.getKey();
//            }
//        }
//        return companyWithLeastConnections;
//    }
    
//    public double calculateAvgConnectionsPerCompany() {
//        if (connections.size() == 0) {
//            return 0; // To avoid division by zero
//        }
//        Map<String, Integer> companyConnectionCount = new HashMap<>();
//        for (Connection connection : connections) {
//            String company = connection.getCompany();
//            companyConnectionCount.put(company, companyConnectionCount.getOrDefault(company, 0) + 1);
//        }
//        int totalCompanies = companyConnectionCount.size();
//        int totalConnections = connections.size();
//        return (double) totalConnections / totalCompanies;
//    }
//    
    
    
}
