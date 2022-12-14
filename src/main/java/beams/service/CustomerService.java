package beams.service;

import beams.entity.Customer;
import beams.mapper.CustomerMapper;
import beams.model.customer.CustomerRequest;
import beams.model.customer.CustomerResponse;
import beams.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    private final CustomerMapper customerMapper ;

    public CustomerResponse saveCustomer(CustomerRequest customerRequest){
        Customer customer = customerMapper.map(customerRequest);
       return customerMapper.map(customerRepository.save(customer));


    }

}
