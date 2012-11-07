package Logic.XMLProcessing.CalcDTO;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author HORUS793
 */
@XStreamAlias("webservice")
public class WebService {
    
    @XStreamAlias("url")
    private String url;

    @XStreamAlias("method")
    private String method;

    @XStreamAlias("params")
    Params params;
    
    @XStreamAlias("result")
    private String result;

    public String getURL() {
        return url;
    }

    public void setURL(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getResultado() {
        return result;
    }

    public void setResultado(String result) {
        this.result = result;
    }

    public Params getParams() {
        return params;
    }

    public void setParams(Params params) {
        this.params = params;
    }
}
