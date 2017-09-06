angular.module("Resiowl",[])
.controller('formctrl',formctrl)
function formctrl(){
    
    var ctrl=this;
    ctrl.correctcaptcha=false;
    ctrl.logstatus=true;
   
    ctrl.submit=function(sform){
        console.log(sform);
    }
    ctrl.statuschange=function(){
        ctrl.logstatus=!ctrl.logstatus;
        console.log(ctrl.logstatus);
    }
    var temp=Math.random();
    temp=temp*20;
    ctrl.captch=(Math.round(temp));
    var captchaarr=['zero','one','two','three','four','five','six','seven','eight','nine','ten','eleven','twelve','thirteen','fourteen','fifteen','sixteen','seventeen','eighteen','nineteen','twenty',];
    ctrl.captcha=captchaarr[ctrl.captch];
    ctrl.check=function(){
        if(ctrl.takecaptcha==ctrl.captch){
            ctrl.correctcaptcha=true;
            console.log(ctrl.correctcaptcha);
        }
        else{
        console.log(ctrl.correctcaptcha)
    }
    }
    

}