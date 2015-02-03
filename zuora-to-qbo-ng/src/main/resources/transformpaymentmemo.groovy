boolean flag = message.getInvocationProperty('memopaydate');

String memo = payload.get('comment');

if (memo == null) {
	memo = '';
}

if (flag) {
	memo = memo + payload.get('createdDate');
}

payload.put('comment', memo);

return payload;