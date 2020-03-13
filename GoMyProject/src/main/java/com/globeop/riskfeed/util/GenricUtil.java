package com.globeop.riskfeed.util;


import java.util.ArrayList;
import java.util.List;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import com.globeop.gocheck.api.ClientRetriever;
import com.globeop.gocheck.api.ClientRetrieverFactory;
import com.globeop.gocheck.api.FundRetriever;
import com.globeop.gocheck.api.FundRetrieverFactory;
import com.globeop.gocheck.api.GoCheckApiConfig;
import com.globeop.gocheck.api.GoCheckApiConfigParser;
import com.globeop.gocheck.core.Client;
import com.globeop.gocheck.core.Fund;
import com.globeop.gocheck.core.FundStatus;
import com.globeop.riskfeed.dto.LabelValueDto;


public class GenricUtil {

    public static List<LabelValueDto> getClientFundList(String clientShortname){
    	List<LabelValueDto> list=new ArrayList<LabelValueDto>();
        try{
            Class clazz = Class.forName("org.apache.xerces.parsers.SAXParser");
            XMLReader reader = (XMLReader) clazz.newInstance();
            GoCheckApiConfigParser goCheckApiConfigParser = new GoCheckApiConfigParser(reader);
            reader.setContentHandler(goCheckApiConfigParser);
            reader.parse(new InputSource(Resources.getResourceAsStream("templates/gocheck-api-config.xml")));
            GoCheckApiConfig config = goCheckApiConfigParser.getGoCheckClientConfig();

            FundRetriever fundRetriever = FundRetrieverFactory.newInstance(config);
            ClientRetriever clientRetriever = ClientRetrieverFactory.newInstance(config);
            Client client=clientRetriever.getClient(clientShortname);
            System.out.println(client.getDescription()+">>"+client.getClientId());

            @SuppressWarnings("unchecked")
			List<Fund> fundList=fundRetriever.getFundListForClient(client.getClientId());
            
            for(Fund f:fundList){
                FundStatus fs;
                String status="";
                try{
                    fs = f.getStatus();
                    status=fs.getName();
                }catch (Exception e){

                }
                
                if("Active".equals(status) && f.isTradingEntity()) {
                	LabelValueDto labelValueDto = new LabelValueDto();
                	labelValueDto.setLabel(f.getShortName());
                    labelValueDto.setValue(f.getShortName());
                    list.add(labelValueDto);                    
                }
                //System.out.println(f.getShortName() + ","+status+","+f.getLaunchDate() +","+f.isTradingEntity());
            }
            //System.out.println(list);
            
            //list.forEach(System.out::println);
            //list.stream().forEach(System.out::println);

        }catch (Exception e){
            e.printStackTrace();

        }
        return list;
    }
  

    public static void main(String[] args) throws Exception {        
    	getClientFundList("BFAM");
    }
}
