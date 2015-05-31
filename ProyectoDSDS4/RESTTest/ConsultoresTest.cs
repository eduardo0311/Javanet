using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System.Text;
using System.Net;
using System.IO;
using System.Web.Script.Serialization;

namespace RESTTest
{

    [TestClass]
    public class ConsultoresTest
    {

        [TestMethod]
        public void CRUDTest()

        {

            //Prueba de creación de consultor via HTTP POST
            string postdata = "{\"Codigo\":\"1\",\"Nombre\":\"Juan\",\"Apellido\":\"Gordillo\",\"Especialidad\":\"RRHH\",\"Categoria\":\"Junior\"}"; //JSON
            byte[] data = Encoding.UTF8.GetBytes(postdata);
            HttpWebRequest req = (HttpWebRequest)WebRequest.Create("http://localhost:58823/Consultores.svc/Consultores");
            req.Method = "POST";
            req.ContentLength = data.Length;
            req.ContentType = "application/json";
            var reqStream = req.GetRequestStream();
            reqStream.Write(data, 0, data.Length);
            HttpWebResponse res = null;
            try
            {
                res = (HttpWebResponse)req.GetResponse();
                StreamReader reader = new StreamReader(res.GetResponseStream());
                string consultorjson = reader.ReadToEnd();
                JavaScriptSerializer js = new JavaScriptSerializer();
                Consultor consultorCreado = js.Deserialize<Consultor>(consultorjson);
                Assert.AreEqual("1", consultorCreado.Codigo);
                Assert.AreEqual("Juan", consultorCreado.Nombre);
                Assert.AreEqual("Gordillo", consultorCreado.Apellido);
                Assert.AreEqual("RRHH", consultorCreado.Especialidad);
                Assert.AreEqual("Junior", consultorCreado.Categoria);
            }
             catch (WebException e)
            {
                HttpStatusCode code = ((HttpWebResponse)e.Response).StatusCode;
                string message = ((HttpWebResponse)e.Response).StatusDescription;
                StreamReader reader = new StreamReader(e.Response.GetResponseStream());
                string error = reader.ReadToEnd();
                JavaScriptSerializer js = new JavaScriptSerializer();
                string mensaje = js.Deserialize<string>(error);
                Assert.AreEqual("Consultor ERROR!", mensaje);
            }

            //Prueba obtencion de Consultor HTTP GET.
            HttpWebRequest req2 = (HttpWebRequest)WebRequest.Create("http://localhost:58823/Consultores.svc/Consultores/1");
            req2.Method = "GET";
            HttpWebResponse res2 = (HttpWebResponse)req2.GetResponse();
            StreamReader reader2 = new StreamReader(res2.GetResponseStream());
            string consultorJson2 = reader2.ReadToEnd();
            JavaScriptSerializer js2 = new JavaScriptSerializer();
            Consultor consultorObtenido = js2.Deserialize<Consultor>(consultorJson2);
            Assert.AreEqual("1", consultorObtenido.Codigo);
            Assert.AreEqual("Juan", consultorObtenido.Nombre);
            Assert.AreEqual("Gordillo", consultorObtenido.Apellido);
            Assert.AreEqual("RRHH", consultorObtenido.Especialidad);
            Assert.AreEqual("Junior", consultorObtenido.Categoria);  

        }
    }
}
