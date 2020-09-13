const balanceFormPageScript = function(){
    $( "button#addDetail" ).click(function( e ) {

        $("form#balanceFormReport").reset();
        $("form#balanceFormReport").show();
        $("div#actionBlock").hide();

        console.log(e.target.id)
    })
}
