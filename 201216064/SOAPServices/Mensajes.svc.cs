using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

namespace SOAPServices
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the class name "Mensajes" in code, svc and config file together.
    // NOTE: In order to launch WCF Test Client for testing this service, please select Mensajes.svc or Mensajes.svc.cs at the Solution Explorer and start debugging.
    public class Mensajes : IMensajes
    {

        public string Saludar(string nombre)
        {
            return "Buenas noches " + nombre;
            //throw new NotImplementedException();
        }

        public string Despedir(string nombre, string curso)
        {
            //throw new NotImplementedException();
            return "Chau " + nombre + "! " + curso + " te extrañará...";
        }
    }
}
