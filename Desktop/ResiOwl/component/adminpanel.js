angular.module("adminpanel",[])
.controller("adminctrl",adminctrl)
function adminctrl(){
    var adm=this;
    adm.home=true;
    adm.homeselect=function(){
        adm.home=true;
        adm.result=false;
        adm.about=false;
    }
    adm.resultselect=function(){
        adm.home=false;
        adm.result=true;
        adm.about=false;
    }
    adm.aboutselect=function(){
        adm.home=false;
        adm.result=false;
        adm.about=true;
    }
}