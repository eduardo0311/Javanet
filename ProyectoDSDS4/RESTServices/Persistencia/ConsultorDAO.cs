using RESTServices.Dominio;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Web;

namespace RESTServices.Persistencia
{
    public class ConsultorDAO
    {
        public Consultor Crear(Consultor consultorACrear)
        {
            Consultor consultorCreado = null;
            string sql = "INSERT INTO t_consultor VALUES (@cod, @nom, @ape, @esp)";
            using (SqlConnection con = new SqlConnection(ConexionUtil.Cadena))
            {
                con.Open();
                using (SqlCommand com = new SqlCommand(sql, con))
                {
                    com.Parameters.Add(new SqlParameter("@cod", consultorACrear.Codigo));
                    com.Parameters.Add(new SqlParameter("@nom", consultorACrear.Nombre));
                    com.Parameters.Add(new SqlParameter("@ape", consultorACrear.Apellido));
                    com.Parameters.Add(new SqlParameter("@esp", consultorACrear.Especialidad));
                    com.ExecuteNonQuery();
                }
            }
            consultorCreado = Obtener(consultorACrear.Codigo);
            return consultorCreado;
        }

        private Consultor Obtener(object p)
        {
            throw new NotImplementedException();
        }
        public Consultor Obtener(string codigo)
        {
            Consultor consultorEncontrado = null;
            string sql = "SELECT * FROM t_consultor WHERE codigo=@cod";
            using (SqlConnection con = new SqlConnection(ConexionUtil.Cadena))
            {
                con.Open();
                using (SqlCommand com = new SqlCommand(sql, con))
                {
                    com.Parameters.Add(new SqlParameter("@cod", codigo));
                    using (SqlDataReader resultado = com.ExecuteReader())
                    {
                        if (resultado.Read())
                        {
                            consultorEncontrado = new Consultor()
                            {
                                Codigo = (string)resultado["codigo"],
                                Nombre = (string)resultado["nombre"],
                                Apellido=(string)resultado["apellido"],
                                Especialidad=(string)resultado["especialidad"]
                            };
                        }
                    }
                }
            }
            return consultorEncontrado;

        }
        public Consultor Modificar(Consultor alumnoAModificar)
        {
            return null;
        }
        public void Eliminar(Consultor consultorAEliminar)
        {

        }
        public List<Consultor> ListarTodos()
        {
            return null;
        }
    }
}