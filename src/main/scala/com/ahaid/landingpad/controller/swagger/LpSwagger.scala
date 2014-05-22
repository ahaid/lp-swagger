package com.ahaid.landingpad.controller.swagger

import org.scalatra.swagger.{ApiInfo, NativeSwaggerBase, Swagger}
import org.scalatra.ScalatraServlet
import rl.BuildInfo


class ResourcesApp(implicit val swagger: Swagger) extends ScalatraServlet with NativeSwaggerBase

class LpSwagger extends Swagger(
  Swagger.SpecVersion,
  BuildInfo.version,
  new ApiInfo(
    "LP-SWAGGER",
    "This is a description",
    "Termsofserviceurl",
    "Contact information",
    "license string",
    "license url"))