package bitcamp.app1;

import java.beans.PropertyEditorSupport;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

@ControllerAdvice
public class GlobalControllerAdvice {

  @InitBinder
  public void InitBinder(WebDataBinder binder) {
    DatePropertyEditer propertyEditor = new DatePropertyEditer();
    CarPropertyEditor carPropertyEditor = new CarPropertyEditor();
    EngineProperyEditor engineProperyEditor = new EngineProperyEditor();

    binder.registerCustomEditor(java.util.Date.class, propertyEditor); 
    binder.registerCustomEditor(Car.class, carPropertyEditor);
    binder.registerCustomEditor(Engine.class, engineProperyEditor); 
  }

  class DatePropertyEditer extends PropertyEditorSupport {

    SimpleDateFormat format;

    public DatePropertyEditer() {
      format = new SimpleDateFormat("yyyy-MM-dd");
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
      try {
        Date date = format.parse(text); // String ==> java.util.Date
        setValue(date); // 내부에 저장
      } catch (ParseException e) {
        throw new IllegalArgumentException(e);
      }
    }
  }

  class CarPropertyEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
      String[] texts = text.split(",");

      Car car = new Car();
      car.setModel(texts[0]);
      car.setCapacity(Integer.parseInt(texts[1]));
      car.setAuto(Boolean.parseBoolean(texts[2]));
      car.setCreateDate(java.sql.Date.valueOf(texts[3]));
      setValue(car);
    }
  }

  class EngineProperyEditor extends PropertyEditorSupport {
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
      Engine engine = new Engine();
      String[] texts = text.split(",");

      engine.setModel(texts[0]);
      engine.setCc(Integer.parseInt(texts[1]));
      engine.setValve(Integer.parseInt(texts[2]));

      setValue(engine);
    }
  }
}
