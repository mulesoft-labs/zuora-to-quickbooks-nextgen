def chargeName = payload.get('chargeName');
def startDate = payload.get('serviceStartDate');
def endDate = payload.get('serviceEndDate');

String s1 = null;
String s2 = null;

if (startDate != null)
	s1 = startDate.toString().substring(0,10);
	
if (endDate != null)
	s2 = endDate.toString().substring(0,10);
	            		
if (s1 != null && s2 != null) {
	if (!s1.equalsIgnoreCase(s2))
		chargeName = chargeName + ' ' + s1 + ' to ' + s2;
	else
		chargeName = chargeName + ' ' + s1;
}

return [chargename:chargeName];