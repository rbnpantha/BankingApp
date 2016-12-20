package edu.cs544.eafinal.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import edu.cs544.eafinal.domain.Transaction;
import edu.cs544.eafinal.rest.RestHttpHeader;
import edu.cs544.eafinal.service.TransactionService;

public class TransactionServiceImpl implements TransactionService{

	@Autowired
	RestHttpHeader restHttpHeader;
	
	RestTemplate restTemplate = new RestTemplate();
	
	ObjectMapper objectMapper = new ObjectMapper();
	
	@Override
	public Transaction addTransaction(Transaction transaction) {
		final String uri =
				"http://localhost:8080/BankingRest/transactions/add/";
				 RestTemplate restTemplate = new RestTemplate();
				 Transaction result = restTemplate.postForObject( uri, transaction, Transaction.class);
				 System.out.println(result);
				 return result;
		
	}

	@Override
	public void deleteTransaction(Long AccountId) {
		final String uri =
				"http://localhost:8080/BankingRest/transactions/delete/" +AccountId;
				 Map<String, Long> params = new HashMap<String, Long>();
				 params.put("id", AccountId);
				 RestTemplate restTemplate = new RestTemplate();
				 restTemplate.delete ( uri, params );
				 System.out.println("Successfully Deleted transaction with AccountNo : " + AccountId );
		
	}

	@Override
	public List<Transaction> getAll() {
		ResponseEntity<List<Transaction>> rateResponse =
		        restTemplate.exchange("http://localhost:8080/BankingRest/transactions/",
		                    HttpMethod.GET, null, new ParameterizedTypeReference<List<Transaction>>() {
		            });
		List<Transaction> transactions = rateResponse.getBody();
		for(Transaction transaction : transactions)
			System.out.println(" The transaction amount is  : "+transaction.getTransactionAmount());
		
		return transactions;
		
	}

	@Override
	public Transaction getTransaction(Long AccountId) {
		System.out.println("Inside service impl method!! " +AccountId);		
		String url = "http://localhost:8080/BankingRest/transactions/1";
		Transaction transaction = restTemplate.getForObject(url, Transaction.class, AccountId);
		System.out.println("Usr is : "+ transaction.toString());
		return transaction;
	}

	@Override
	public void updateTransaction(Transaction transaction) {
		final String uri =
				"http://localhost:8080/BankingRest/transactions/delete/{id}";
				 Map<String, String> params = new HashMap<String, String>();
				 params.put("id", "2");
				 Transaction updateTransaction = new Transaction();
				 
				 RestTemplate restTemplate = new RestTemplate();
				 restTemplate.put ( uri, updateTransaction, params);
		
	}

}
