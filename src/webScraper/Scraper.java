/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package webScraper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 *
 * @author Dagoberto
 */
public class Scraper {
    
    String codigoDivisa;
    String conversion_a_dolar;
    float conversion;
    
    public Scraper(){      
           
    }
    
    
    public float extraerDatosMoneda(String codigoMoneda){
        final String url = "https://www.xe.com/currencytables/?from=USD";
        
        try{
            final Document document = Jsoup.connect(url).get();
            
            for(Element row : document.select("table.sc-8b336fdc-3.foLGOz tr")){
               if(row.select("th").text().equals("")){
                   continue;
               }else if(!row.select("th").text().equals(codigoMoneda)){
                   continue;
               }
               else{
                   codigoDivisa = row.select("th").text();
                   conversion_a_dolar = row.select("td:nth-of-type(2)").text();                   
               } 
            }
            
        }catch(Exception ex){
           ex.printStackTrace();
        }
        
        conversion = Float.parseFloat(conversion_a_dolar);
        
        return conversion;
    }
}
