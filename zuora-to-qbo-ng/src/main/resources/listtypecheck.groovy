def outlist = payload;

if (!(payload instanceof List)) {
	outlist = [payload];
}

return outlist;