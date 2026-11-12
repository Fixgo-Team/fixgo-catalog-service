# fixgo-catalog-service

Microservicio de catálogo de FixGo: profesionales, verificación, categorías, subservicios y agenda.

**Fase 1:** categorías y subservicios (RF2.4 y RF2.5 del SRS 3.0).

| Dato | Valor |
|---|---|
| Puerto | 8083 |
| Base de datos | `fixgo_catalog` (MySQL / MariaDB) |
| Migraciones | Flyway (`src/main/resources/db/migration`) |
| Hibernate | `ddl-auto=validate` |
| Swagger | http://localhost:8083/swagger-ui.html |
| Responsable | Gabriel Tijaro Jimenez |

## Endpoints

| Método | Ruta | Qué hace |
|---|---|---|
| GET | `/api/categories` | Listar todas |
| GET | `/api/categories/active` | Listar activas |
| GET | `/api/categories/{id}` | Buscar por id |
| GET | `/api/categories/name/{name}` | Buscar por nombre |
| POST | `/api/categories` | Guardar |
| PUT | `/api/categories/{id}` | Actualizar |
| DELETE | `/api/categories/{id}` | Desactivar (borrado lógico) |
| GET | `/api/service-types` | Listar todos |
| GET | `/api/service-types/active` | Catálogo público (activos de categorías activas) |
| GET | `/api/service-types/urgent` | Solo los que admiten urgencia |
| GET | `/api/service-types/category/{categoryId}` | Subservicios de una categoría |
| GET | `/api/service-types/search?name=...` | Buscar por parte del nombre |
| GET | `/api/service-types/{id}` | Buscar por id |
| POST | `/api/service-types` | Guardar |
| PUT | `/api/service-types/{id}` | Actualizar |
| DELETE | `/api/service-types/{id}` | Desactivar (borrado lógico) |

La colección de Postman está en `postman/`.
