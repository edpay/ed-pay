package com.edpay.exceptionHandler;

public class Validate {


    public static void assertTrue(boolean flag, IIErrorCodeDescription errorCode) throws RestException {
        if (!flag)
            throw new BadRequestException(errorCode);
    }

    public static void assertFalse(boolean flag, IIErrorCodeDescription errorCode) throws RestException {
        if (flag)
            throw new BadRequestException(errorCode);
    }


    public static void notNull(Object object, IIErrorCodeDescription errorCode) throws RestException {
        if (object == null)
            throw new BadRequestException(errorCode);
    }
    
    public static Boolean checkRequired(String parameter)  {
    	if(parameter==null || (parameter != null && parameter.trim().length()==0))
    		return true;
		return false;
    }
    
    public static Boolean checkOptional(String parameter)  {
    	if(parameter != null && parameter.trim().length()==0)
    		return true;
		return false;
    }

	public static boolean checkEmpty(String parameter) {
		// TODO Auto-generated method stub
		if(parameter != null && parameter.trim().length()>0)
    		return true;
		return false;
	}

    /*public static <E> E checkPattern(E object, String parameterName) throws RestException {
        if (object == null)
            return null;
        String[] patternAndErrorMessage = ParameterFormat.getPatternAndErrorMessage(parameterName);
        if (patternAndErrorMessage == null)
            return object;
        String parameterPattern = patternAndErrorMessage[0];
        String errorMessage = patternAndErrorMessage[1];
        Pattern pattern = Pattern.compile(parameterPattern);
        Matcher matcher = pattern.matcher(object.toString());
        boolean matchFound = matcher.matches();
        if (!matchFound) {
            // String message = "Parameter '" + parameterName + "' is in invalid format";
            //InvalidParameterFormatException ex = new InvalidParameterFormatException(errorMessage + " : the regex is : " + parameterPattern);
            InvalidParameterFormatException ex = new InvalidParameterFormatException(errorMessage);
            throw ex;
        }
        return object;
    }*/
}
