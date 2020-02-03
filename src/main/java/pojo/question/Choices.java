package pojo.question;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;

/**
 * Awesome Pojo Generator
 * */
@Getter
public class Choices{
  @SerializedName("visible")
  @Expose
  private Boolean visible;
  @SerializedName("quiz_options")
  @Expose
  private Quiz_options quiz_options;
  @SerializedName("position")
  @Expose
  private Integer position;
  @SerializedName("text")
  @Expose
  private String text;
  @SerializedName("id")
  @Expose
  private Long id;
}