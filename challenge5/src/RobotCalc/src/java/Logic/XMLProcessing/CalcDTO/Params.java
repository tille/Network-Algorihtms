package Logic.XMLProcessing.CalcDTO;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 *
 * @author HORUS793
 */
@XStreamAlias("params")
public class Params {
    
    @XStreamAlias("p1")
    private String p1;

    @XStreamAlias("p2")
    private String p2;
    
    public String getP1() {
        return p1;
    }

    public void setP1(String p1) {
        this.p1 = p1;
    }

    public String getP2() {
        return p2;
    }

    public void setP2(String p2) {
        this.p2 = p2;
    }
}