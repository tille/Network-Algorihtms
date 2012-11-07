package Test;

import Controller.CalcProxy;
import Logic.XMLProcessing.CalcDTO.WebService;
import Logic.XMLProcessing.CalcDTO.WebServices;
import Logic.XMLProcessing.XMLOperationsSingleton;
import Logic.XMLProcessing.XMLTransformations.XMLOperations;

/**
 *
 * @author HORUS793
 */
public class Test {

    public static void main(String[] args) {
        XMLOperationsSingleton xmlSingleton = XMLOperationsSingleton.getInstance();
        String strFileName = "E:\\Projects\\Java\\Telematics\\RobotCalc\\CalcServer.xml";
        WebServices webServices = xmlSingleton.getWebServices(strFileName);
        for (WebService webService : webServices.getWebServices()) {
            String strP1 = webService.getParams().getP1();
            String strP2 = webService.getParams().getP2();
            float nmFirst = Float.parseFloat(strP1);
            float nmSecond = Float.parseFloat(strP2);
            String strResult = String.valueOf(ExecuteOperation(nmFirst, nmSecond, webService.getMethod()));
            webService.setResultado(strResult);
        }
        XMLOperations.WriteXMLFile(strFileName, xmlSingleton.getDOMWebServices(webServices));
    }
    
    public static float ExecuteOperation(float nmFirst, float nmSecond, String strOperator) {
        float result = 0;
        CalcProxy proxy = new CalcProxy();
        if(strOperator != null && !strOperator.equals("")) {
            char chOperator = strOperator.charAt(0);
            if(chOperator ==  '+') {
                result = proxy.Add(nmFirst,nmSecond);
            } else if(chOperator ==  '-') {
                result = proxy.Substract(nmFirst, nmSecond);
            } else if(chOperator ==  '*') {
                result = proxy.Multiply(nmFirst, nmSecond);
            } else if(chOperator ==  '/') {
                result = proxy.Divide(nmFirst, nmSecond);
            }
        }
        return result;
    }
}
