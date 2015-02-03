package com.mulesoft.zuora.qb;

import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.config.i18n.MessageFactory;
import org.mule.transformer.AbstractMessageTransformer;

import com.zuora.api.object.ZObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ZObjectListToMapTransformer extends AbstractMessageTransformer {

	protected final transient Log log = LogFactory.getLog(getClass());


    @Override
    public Object transformMessage(MuleMessage message, String outputEncoding)
            throws TransformerException {
        Object payload = message.getPayload();
        if (payload instanceof Iterable) {
            ArrayList<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
            for(Object o :  (Iterable) payload){
                HashMap<String, Object> hm = toMap(o);
                
                resultList.add( hm);
                log.debug(hm);
            }
            log.debug(resultList);
            return resultList;
        } else if (payload instanceof ZObject) {
            return toMap(payload);
        } else {
            throw new TransformerException(MessageFactory.createStaticMessage("Invalid payload type for transformer: " + payload.getClass().getName()), this);
        }
    }

    private HashMap<String, Object> toMap(Object o) {
        HashMap<String,Object> hm = new HashMap<String,Object>();
        for(Entry<String,Object> e : ((ZObject) o).properties()){
            hm.put(e.getKey(),e.getValue());
        }
        return hm;
    }

}
