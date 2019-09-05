package hibernate.kotlin.utility

import org.hibernate.SessionFactory
import org.hibernate.boot.registry.StandardServiceRegistryBuilder
import org.hibernate.cfg.Configuration
import org.hibernate.service.ServiceRegistry

object SessionFactoryUtil {

    var sessionFactory: SessionFactory

    init {
        val configuration = Configuration().configure()
        configuration.setProperty("hibernate.connection.username", System.getenv("DB_USERNAME"))
        configuration.setProperty("hibernate.connection.password", System.getenv("DB_PASSWORD"))
        configuration.setProperty("hibernate.connection.url", System.getenv("DB_URL"))
        configuration.setProperty("hibernate.default_schema", System.getenv("DB_SCHEMA"))
        val serviceRegistry = StandardServiceRegistryBuilder()
            .applySettings(configuration.properties).build()
        sessionFactory = configuration.buildSessionFactory(serviceRegistry)
    }
}
