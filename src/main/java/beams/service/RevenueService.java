package beams.service;

import beams.entity.Revenue;
import beams.mapper.RevenueMapper;
import beams.model.revenue.RevenueRequest;
import beams.model.revenue.RevenueResponse;
import beams.repository.RevenueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class RevenueService {

    private final RevenueRepository revenueRepository;
    private final RevenueMapper revenueMapper;


    public RevenueResponse addRevenue(RevenueRequest revenueRequest){
        Revenue revenue =revenueMapper.map(revenueRequest);
        return revenueMapper.map(revenueRepository.save(revenue));
    }


}
