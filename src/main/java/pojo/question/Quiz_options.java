package pojo.question;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;

/**
 * Awesome Pojo Generator
 * */
@Getter
public class Quiz_options{
  @SerializedName("score")
  @Expose
  private Integer score;
}