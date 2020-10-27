import cn.nio.common.HttpClientUtils;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * @author yd
 * @version 1.0
 * @date 2020-10-27 15:49
 */
public class HttpClientTest {

    public static void main(String[] args) {
        ResponseEntity<JSONObject> jsonObjectResponseEntity = HttpClientUtils.get("localhost:8801", JSONObject.class);
    }

}
