package com.globeop.riskfeed.util;


import java.util.ArrayList;
import java.util.List;
import com.globeop.riskfeed.dto.LabelValueDto;



public class GenricUtil {

	/*
	 * public static List<LabelValueDto> getClientFundList(String clientShortname){
	 * List<LabelValueDto> list=new ArrayList<LabelValueDto>(); try{ Class clazz =
	 * Class.forName("org.apache.xerces.parsers.SAXParser"); XMLReader reader =
	 * (XMLReader) clazz.newInstance(); GoCheckApiConfigParser
	 * goCheckApiConfigParser = new GoCheckApiConfigParser(reader);
	 * reader.setContentHandler(goCheckApiConfigParser); reader.parse(new
	 * InputSource(Resources.getResourceAsStream("templates/gocheck-api-config.xml")
	 * )); GoCheckApiConfig config =
	 * goCheckApiConfigParser.getGoCheckClientConfig();
	 * 
	 * FundRetriever fundRetriever = FundRetrieverFactory.newInstance(config);
	 * ClientRetriever clientRetriever = ClientRetrieverFactory.newInstance(config);
	 * Client client=clientRetriever.getClient(clientShortname);
	 * System.out.println(client.getDescription()+">>"+client.getClientId());
	 * 
	 * @SuppressWarnings("unchecked") List<Fund>
	 * fundList=fundRetriever.getFundListForClient(client.getClientId());
	 * 
	 * for(Fund f:fundList){ FundStatus fs; String status=""; try{ fs =
	 * f.getStatus(); status=fs.getName(); }catch (Exception e){
	 * 
	 * }
	 * 
	 * if("Active".equals(status) && f.isTradingEntity()) { LabelValueDto
	 * labelValueDto = new LabelValueDto();
	 * labelValueDto.setLabel(f.getShortName());
	 * labelValueDto.setValue(f.getShortName()); list.add(labelValueDto); }
	 * //System.out.println(f.getShortName() + ","+status+","+f.getLaunchDate()
	 * +","+f.isTradingEntity()); } //System.out.println(list);
	 * 
	 * //list.forEach(System.out::println);
	 * //list.stream().forEach(System.out::println);
	 * 
	 * }catch (Exception e){ e.printStackTrace();
	 * 
	 * } return list; }
	 */
  

	
	public static List<LabelValueDto> getClientFundList(String clientShortname){
		 List<LabelValueDto> list=new ArrayList<LabelValueDto>();
		 LabelValueDto l1 = new LabelValueDto();
		 l1.setLabel("FUND1");
		 l1.setValue("FUND1");
		 
		 LabelValueDto l2 = new LabelValueDto();
		 
		 l2.setLabel("FUND2");
		 l2.setValue("FUND2");
		 
		 LabelValueDto l3 = new LabelValueDto();
		 l3.setLabel("FUND3");
		 l3.setValue("FUND3");
		 
		 LabelValueDto l4 = new LabelValueDto();
		 l4.setLabel("FUND4");
		 l4.setValue("FUND4");
		 
		 list.add(l1);
		 list.add(l2);
		 list.add(l3);
		 list.add(l4);
		 return list;
	}
		
    public static void main(String[] args) throws Exception {        
    	//getClientFundList("BFAM");
    }
}
