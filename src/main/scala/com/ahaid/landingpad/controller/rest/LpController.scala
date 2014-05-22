package com.ahaid.landingpad.controller.rest

import org.scalatra._
import org.scalatra.swagger.{Swagger, SwaggerSupport}
import org.scalatra.json.JacksonJsonSupport
import org.json4s.{Formats, DefaultFormats}
import org.slf4j.LoggerFactory

class LpController (implicit val swagger: Swagger)
  extends ScalatraServlet with JacksonJsonSupport with SwaggerSupport {

  val logger = LoggerFactory.getLogger(this.getClass)

  protected implicit val jsonFormats: Formats = DefaultFormats

  override protected val applicationName: Option[String] = Some("lp-swagger")

  protected val applicationDescription = "Application description for Lp Controller."

  // Before every action runs, set the content type to be in JSON format.
  before() {
    contentType = formats("json")
    response.headers += ("Access-Control-Allow-Origin" -> "*")
  }

  get("/methods", operation(apiOperation[String]
    ("methods")
    .summary("methods endpoint summary")
    .notes("These are the notes for the methods endpoint"))) {
    {
      Ok("Successfully called /methods")
    }
  }
}

