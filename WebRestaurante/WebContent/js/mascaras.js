/**
 * Created by Jezreel on 08/04/2016.
 */

function mascaraCEP(evento, mask){
    var i = evento.value.length;
    var saida = mask.substring(1,0);
    var texto = mask.substring(i)
    if (texto.substring(0,1) != saida){
        evento.value += texto.substring(0,1);
    }
    return somenteNumero(evento);
}
function somenteNumero(evento){
    var tecla=(window.event)? event.keyCode:evento.which;
    if((tecla>47 && tecla<58)) return true;
    else{
        if (tecla==8 || tecla==0) return true;
        else  return false;
    }
}
function mascaraTEL(evento, mask){
    var i = evento.value.length;
    var saida = mask.substring(2,1);
    var texto = mask.substring(i)
    if (texto.substring(0,1) != saida){
        evento.value += texto.substring(0,1);
    }
    return somenteNumero(evento);
}