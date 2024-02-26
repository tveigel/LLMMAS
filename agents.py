
import autogen
import openai 
from autogen import AssistantAgent, UserProxyAgent, GroupChatManager, ConversableAgent
import os
from messages import system_message_entity_coder, system_message_assistant_agent, system_message_repository_coder


# Change the directories to pick up the files. Ensure you use your own OpenAI API Keys
index_path = r"C:\Users\timveigel\Documents\Masterarbeit\Gabis first assistant\\Gabis-MVP Springboot"

configurations_path = r"C:\Users\timveigel\Documents\Masterarbeit\Gabis first assistant\\Gabis-MVP Springboot"




config_list = autogen.config_list_from_json(
    env_or_file="configurations.json",
    file_location=configurations_path,
    filter_dict={
        "model": ["gpt-4-1106-preview"]
    },
)


api_key = os.getenv("OPENAI_API_KEY")
openai.api_key = api_key


llm_config = {
    "config_list": config_list,
    "seed": 42,
    "timeout": 120
}

# You can also set config_list directly as a list, for example, config_list = [{'model': 'gpt-4', 'api_key': '<your OpenAI API key here>'},]
assistant = AssistantAgent(name="assistant",
                           system_message=system_message_assistant_agent,
                            llm_config={"config_list": config_list})
user_proxy = UserProxyAgent(name="user_proxy",
                            system_message="Terminate when agent says TERMINATE",
                            human_input_mode="NEVER",
                            is_termination_msg=lambda x: x.get("content", "") and x.get("content", "").rstrip().endswith("TERMINATE"),
                             code_execution_config={"work_dir": index_path, "use_docker": False}) # IMPORTANT: set to True to run code in docker, recommended
entity_coder= autogen.AssistantAgent(name ="entity_coder",
                                    system_message=system_message_entity_coder,
                                    human_input_mode="NEVER",
                                     llm_config={"config_list": config_list})

repository_coder= autogen.AssistantAgent(name ="repo_coder",
                                    system_message=system_message_repository_coder,
                                    human_input_mode="NEVER",
                                     llm_config={"config_list": config_list})