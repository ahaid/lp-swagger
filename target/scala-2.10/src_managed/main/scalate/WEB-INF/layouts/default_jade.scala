/* NOTE this file is autogenerated by Scalate : see http://scalate.fusesource.org/ */
package scalate.layouts

object $_scalate_$default_jade {
  def $_scalate_$render($_scalate_$_context: _root_.org.fusesource.scalate.RenderContext): Unit = {
    import _root_.org.fusesource.scalate.support.RenderHelper.{sanitize=>$_scalate_$_sanitize, preserve=>$_scalate_$_preserve, indent=>$_scalate_$_indent, smart_sanitize=>$_scalate_$_smart_sanitize, attributes=>$_scalate_$_attributes}
    ;{
      val context: _root_.org.fusesource.scalate.RenderContext = $_scalate_$_context.attribute("context")
      import context._
      
      
      ;{
        val body: String = $_scalate_$_context.attribute("body")
        ;{
          val title: String = $_scalate_$_context.attributeOrElse("title", "Enter your layout title here")
          ;{
            val appName: String = $_scalate_$_context.attributeOrElse("appName", "scalatraapp")
            $_scalate_$_context << ( "<!DOCTYPE html>\n<html" );
            $_scalate_$_context << $_scalate_$_attributes( $_scalate_$_context, List( (
                "lang"
              ,
                "en"
              ), (
                "ng-app"
              ,
                                appName

            ) ) )
            $_scalate_$_context << ( ">\n  <head>\n    <meta charset=\"utf-8\"/>\n    <title>" );
            $_scalate_$_context << ( $_scalate_$_indent ( "    ", $_scalate_$_context.value(
              title
            ) ) );
            $_scalate_$_context << ( "</title>\n    <link rel=\"stylesheet\" href=\"/compiled/styles.css\"/>\n    <link rel=\"stylesheet\" href=\"\"/>\n    <link href=\"http://netdna.bootstrapcdn.com/twitter-bootstrap/2.2.2/css/bootstrap.min.css\" rel=\"stylesheet\"/>\n    <script src=\"https://ajax.googleapis.com/ajax/libs/angularjs/1.0.4/angular.min.js\"></script>\n    <script src=\"http://cdnjs.cloudflare.com/ajax/libs/underscore.js/1.4.4/underscore-min.js\"></script>\n    <script src=\"/js/ui-bootstrap-tpls-0.2.0.min.js\"></script>\n    <script src=\"/application.js\"></script>\n    <script src=\"/controllers.js\"></script>\n    <script src=\"/directives.js\"></script>\n    <script src=\"/filters.js\"></script>\n    <script src=\"/services.js\"></script>\n    " );
            $_scalate_$_context << ( $_scalate_$_indent ( "    ", $_scalate_$_context.value ( _root_.org.fusesource.scalate.filter.FilterRequest("css", $_scalate_$_context.capture { 
              $_scalate_$_context << ( "body {\n  padding-top: 60px; /* 60px to make the container go all the way to the bottom of the topbar */\n}" );
            } ) ) ) );
            $_scalate_$_context << ( "\n  </head>\n  <body>\n" );
            $_scalate_$_context << ( $_scalate_$_context.valueUnescaped(
               body
            ) );
            $_scalate_$_context << ( "\n  </body>\n</html>\n" );
          }
        }
      }
    }
  }
}


class $_scalate_$default_jade extends _root_.org.fusesource.scalate.Template {
  def render(context: _root_.org.fusesource.scalate.RenderContext): Unit = $_scalate_$default_jade.$_scalate_$render(context)
}
