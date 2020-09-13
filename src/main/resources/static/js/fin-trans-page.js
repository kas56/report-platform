const finTransPageScript = function(){
    $( "button#addFinTrans" ).click(function( e ) {

        $("form#finTransForm").show();
        $("div#actionBlockFin").hide();

        console.log(e.target.id)
    })
};