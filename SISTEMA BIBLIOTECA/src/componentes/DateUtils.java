/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentes;

import java.util.Date;

/**
 *
 * @author Edivaldo
 */
public class DateUtils {

    public static String convertData(Date data) {

        String retorno = "";
        retorno = retorno + (data.getYear() + 1900);

        if ((data.getMonth() + 1) < 10) {
            retorno = retorno + "0" + (data.getMonth() + 1);
        } else {
            retorno = retorno + (data.getMonth() + 1);
        }
        if (data.getDate() < 10) {
            retorno = retorno + "0" + (data.getDate());
        } else {
            retorno = retorno + (data.getDate());
        }
        return retorno;
    }

}
