function() {
    var index = 0;
    this.items.each(function(i){
        if (typeof i.field !== 'undefined' && i.hasOwnProperty('xtype') && i.xtype === 'multifielditem') {
            var field = i.field;
            if (typeof field.items !== 'undefined') {
                index++;
                field.items.each(function(j) {
                    if (j.hasOwnProperty('dName') && j.dName === 'levelValue') {
                        j.setValue(index);
                    }
                });
            }
        }
    });
}