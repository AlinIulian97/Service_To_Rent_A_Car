package beams.service;

import beams.entity.Customer;
import beams.exception.BusinessException;
import beams.mapper.CustomerMapper;
import beams.model.customer.CustomerRequest;
import beams.model.customer.CustomerResponse;
import beams.model.customer.UpdateCustomerResponse;
import beams.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.util.List;

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

    public void deleteCustomer(Integer id){
        Customer customerToDelete =customerRepository.findById(id).orElseThrow(
                ()-> new BusinessException("Customer not found")
        );
        customerRepository.delete(customerToDelete);
    }

    public CustomerResponse findById(Integer id){
        return customerMapper.map(customerRepository.findById(id).orElseThrow(
                () -> new BusinessException("Customer not found")
        ));
    }

    public void updateCustomer(UpdateCustomerResponse customerUpdateResponse, Integer id) {
        Customer customerToUpdate =customerRepository.findById(id).orElseThrow(
                ()-> new BusinessException("No customer fund")
        );
        customerToUpdate.setAddress(customerUpdateResponse.getAddress());
        customerToUpdate.setEmail(customerUpdateResponse.getEmail());
    }

    public List<CustomerResponse> customers(){
        return customerMapper.map(customerRepository.findAll());
    }
}
