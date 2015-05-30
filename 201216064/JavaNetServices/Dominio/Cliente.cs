using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Web;

namespace JavaNetServices.Dominio
{
    [DataContract]
    public class Cliente
    {
        [DataMember]
        public int CodCliente { get; set; }
        [DataMember]
        public string RazonSocialCliente { get; set; }
        [DataMember]
        public int RucCliente { get; set; }
        [DataMember]
        public string Correo { get; set; }

    }
}