package com.clip.transactions.service;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.boot.ApplicationArguments;

public  class Util {
	
	
	public static  Map<String, Object> getNotOptionArguments (ApplicationArguments  args)throws Exception{
		
			
		List<String> nameParams = new ArrayList<>(Arrays.asList("userid", "command", "transaction"));
		List<String> valueParams = args.getNonOptionArgs();
		Map<String, Object> arguments = new HashMap<String, Object>();
		try {
			if(!valueParams.isEmpty()) {
				for (int i = 0; i < nameParams.size(); i++){
					arguments.put(nameParams.get(i), valueParams.get(i));
		        }
			}
			return arguments;
		}catch (Exception e) {
			return arguments;
		}
	}

	public static boolean validateNull(Object pObjeto) {
        Method metodos[] = pObjeto.getClass().getMethods();
        for (int i = 0; i < metodos.length; i++) {
            Method metodo = metodos[i];
            if ((metodo.getName().substring(0, 3).equalsIgnoreCase("get") || metodo.getName().substring(0, 2).equalsIgnoreCase("is")) && !metodo.getName().equals("getClass")) {
                String methodNameSet = "";
                if(metodo.getName().substring(0, 3).equalsIgnoreCase("get")){
                    methodNameSet = metodo.getName().replaceFirst("get", "set");
                }else{
                    methodNameSet = methodNameSet.replaceFirst("is", "set");
                }
                try {
                    Method metodoSet = pObjeto.getClass().getMethod(methodNameSet, metodo.getReturnType());
                    if (metodoSet != null) {
                        if (metodo.getReturnType().equals(java.lang.Byte.class)) {
                            Byte valor = (Byte)metodo.invoke(pObjeto, new Object[0]);
                            if(valor==null){
                                return true;
                            }
                        }
                        if (metodo.getReturnType().equals(java.math.BigDecimal.class)) {
                            BigDecimal valor = (BigDecimal)metodo.invoke(pObjeto, new Object[0]);
                            if(valor==null){
                            	return true;
                            }
                        }
                        if (metodo.getReturnType().equals(java.lang.Double.class)) {
                            Double valor = (Double)metodo.invoke(pObjeto, new Object[0]);
                            if(valor==null){
                            	return true;
                            }
                        }
                        if (metodo.getReturnType().equals(java.lang.String.class)) {
                            String valor = (String)metodo.invoke(pObjeto, new Object[0]);
                            if(valor==null){
                            	return true;
                            }
                        }
                        if (metodo.getReturnType().equals(java.util.Date.class)) {
                            Date valor = (Date)metodo.invoke(pObjeto, new Object[0]);
                            if(valor==null){
                            	return true;
                            }
                        }
                        if (metodo.getReturnType().isPrimitive()) {
                            //los primitivos no permiten null
                        }
                    }
                } catch (Exception e) {
                }
            }
        }
        return false;
    }
	
}
