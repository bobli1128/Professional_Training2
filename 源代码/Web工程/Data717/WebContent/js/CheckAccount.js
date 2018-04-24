/**
 * 
 */
function toChinese( strvalue) {   
   if(strvalue==null||strvalue.equals("")){
    return "";
   }else{
    strvalue=new String(strvalue.getBytes("ISO-8859-1"),"UTF-8");
    return strvalue;
   } 
 }
function CheckAccount(){
	var account = document.getElementById('Uaccount');
	var flag=false;
	
}