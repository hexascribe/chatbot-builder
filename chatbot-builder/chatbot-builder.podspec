Pod::Spec.new do |spec|
    spec.name                     = 'chatbot-builder'
    spec.version                  = '0.0.1'
    spec.homepage                 = 'https://github.com/ars-techna/chatbot-builder'
    spec.source                   = { :http=> ''}
    spec.authors                  = ''
    spec.license                  = ''
    spec.summary                  = 'ChatBot Builder is a SDK that you can seamlessly customize the Chat UI to match the look and feel of your application, while also having the ability to define specific instructions for the bots behavior.'
    spec.vendored_frameworks      = 'build/cocoapods/framework/ChatBotBuilder.framework'
    spec.libraries                = 'c++'
    spec.ios.deployment_target = '14.1'
                
                
    spec.pod_target_xcconfig = {
        'KOTLIN_PROJECT_PATH' => ':chatbot-builder',
        'PRODUCT_MODULE_NAME' => 'ChatBotBuilder',
    }
                
    spec.script_phases = [
        {
            :name => 'Build chatbot-builder',
            :execution_position => :before_compile,
            :shell_path => '/bin/sh',
            :script => <<-SCRIPT
                if [ "YES" = "$OVERRIDE_KOTLIN_BUILD_IDE_SUPPORTED" ]; then
                  echo "Skipping Gradle build task invocation due to OVERRIDE_KOTLIN_BUILD_IDE_SUPPORTED environment variable set to \"YES\""
                  exit 0
                fi
                set -ev
                REPO_ROOT="$PODS_TARGET_SRCROOT"
                "$REPO_ROOT/../gradlew" -p "$REPO_ROOT" $KOTLIN_PROJECT_PATH:syncFramework \
                    -Pkotlin.native.cocoapods.platform=$PLATFORM_NAME \
                    -Pkotlin.native.cocoapods.archs="$ARCHS" \
                    -Pkotlin.native.cocoapods.configuration="$CONFIGURATION"
            SCRIPT
        }
    ]
    spec.resources = ['src/commonMain/resources/**', 'src/iosMain/resources/**']
end