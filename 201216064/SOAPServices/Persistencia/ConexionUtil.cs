using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace SOAPServices.Persistencia
{
    public class ConexionUtil
    {
        public static string ObtenerCadena()
        {
            return "Data Source=(local);Initial Catalog=BD_Asesores;Integrated Security=SSPI;";
            //return "Data Source=(USUARIO-PC\SQLEXPRESS);Initial Catalog=BD_Asesores;Integrated Security=SSPI;";
     
        }
    }
}