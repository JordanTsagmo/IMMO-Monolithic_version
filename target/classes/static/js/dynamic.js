//function for check if the form is correct
function checkForm(){
    let name= document.forms["RegForm"]["nom_bailleur"]
    let lastName=document.forms["RegForm"]["prenom_bailleur"]
    let login=document.document.forms["RegForm"]["login"]
    let password=document.forms["RegForm"]["mot_de_passe"]
    let cni=document.forms["RegForm"]["Numero_cni"]
    let telephone=document.forms["RegForm"]["telephone"]

    if(name == ""){
        alert("renseignez le nom svp");
        name.focus();
        return false;
    }

    if(lastName == ""){
        alert("renseignez le nom svp");
        lastName.focus();
        return false;
    }

   /* if(name == ""){
        alert("renseignez le nom svp");
        name.focus();
        return false;
    }

    if(name == ""){
        alert("renseignez le nom svp");
        name.focus();
        return false;
    }

    if(name == ""){
        alert("renseignez le nom svp");
        name.focus();
        return false;
    }*/

}