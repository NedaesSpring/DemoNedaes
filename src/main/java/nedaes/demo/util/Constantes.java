package nedaes.demo.util;
import java.io.Serializable;

/**
 * Clase que contiene las variables comunes mas utilizadas (constantes) en la aplicación NEDAES.
 *
 * @exclude <br>
 * Copyright (C) <b>2022</b> MINISTERIO DE ECONOMIA<br>
 * Spain<br>
 * <br>
 * Developed by <b>SERIKAT</b> for <b>MINISTERIO DE ECONOMICA</b><br>
 * Authors: Raquel Gomez<br>
 * <br>
 * This file is part of <b>Regislab</b>.<br>
 * Descripción <b>Nedaes</b><br>
 * <br>
 * <b>Nedaes</b> is licensed under the EUPL, Version 1.1 or ? as soon they will be approved
 * by the European Commission - subsequent versions of the EUPL (the "Licence");<br>
 * You may not use this work except in compliance with the Licence.<br>
 * You may obtain a copy of the Licence at:<br>
 * <br>
 * https://joinup.ec.europa.eu/software/page/eupl<br>
 * <br>
 * Unless required by applicable law or agreed to in writing, software distributed under the Licence is
 * distributed on an "AS IS" basis, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the Licence for the specific language governing permissions and limitations under the Licence.<br>
 */
public class Constantes implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 5322193363813838575L;

	/**

	/** Nombre de la aplicación. */
    public static final String APLICACION = "NEDAES";

    /** Mensajes de error inesperado. */
    public static final String ERROR_INESPERADO = "Error inesperado, consulte a su administrador.";
    /** Mensajes de error de documento no encontrado. */
    public static final String ERROR_DOCUMENTO = "Documento no encontrado en el sistema.";
    /** Mensajes de error de acción no encontrada. */
    public static final String ERROR_ACCION = "No se podido determinar la acción a realizar.";
    /** Mensajes de aviso en filtros de búsqueda sin parámetros. */
    public static final String AVISO_NO_HAY_PARAMETROS = "Debe rellenar algún campo para poder realizar una búsqueda.";
    /** Mensajes de aviso de datos inexistentes. */
    public static final String AVISO_NO_HAY_DATOS = "No se han encontrado datos en el sistema.";
    /** Mensajes de resultado de operación correcta. */
    public static final String OPERACION_CORRECTA = "La operación se ha realizado correctamente.";

    /** Constante para el nombre del usuario en la session. */
    public final static String USUARIO_SESSION = "USUARIO";

    // FORMATOS
    /** Patrón <b><i>dd/MM/yyyy</i></b> de formateo de fechas. */
    public static final String DEFAULT_DATE_FORMAT = "dd/MM/yyyy";
    /** Patrón <b><i>dd/MM/yyyy HH:mm:ss</i></b> de formateo de fechas. */
    public static final String FORMATO_FECHA_LONG = "dd/MM/yyyy HH:mm:ss";
    /** Expresión regular de validez de fechas. */
    public static final String PATTERN_FECHA = "(((0[1-9]|1[0-9]|2[0-8])[\\/](0[1-9]|1[012]))|((29|30|31)[\\/](0[13578]|1[02]))|((29|30)[\\/](0[4,6,9]|11)))[\\/](19|[2-9][0-9])\\d\\d$)|(^29[\\/]02[\\/](19|[2-9][0-9])(00|04|08|12|16|20|24|28|32|36|40|44|48|52|56|60|64|68|72|76|80|84|88|92|96)";
    /** Patrón <b><i>###,##0</i></b> de formateo de números enteros. */
    public static final String FORMATO_INTEGER = "###,##0";
    /** Patrón <b><i>###,##0.00</i></b> de formateo de números decimales. */
    public static final String FORMATO_DECIMAL = "###,##0.00";
    /** Patrón <b><i>fm999G999G999G990D099</i></b> de formateo de números decimales en Oracle. */
    public static final String FORMATO_DECIMAL_ORACLE = "fm999G999G999G990D999";

    /** Identificador del país <b><i>España</i></b>. */
    public static final String ID_PAIS = "ES";
    public static final String RUTA_GRAL = "src/main/resources/static/";        

}
